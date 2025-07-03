import android.Manifest
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.provider.Settings
import android.telephony.PhoneStateListener
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R
import kotlinx.coroutines.delay
import androidx.core.net.toUri
import com.example.arquivomobileoficialnitro.ui.screen.EmergencyOverlayService

@Composable
fun PoliceEmergencyScreen(paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val textos = listOf(
        "Uma \nambulância ", "Uma \nautoridade policial ", "Um \ncaminhão de bombeiro "
    )
    val finalDoTexto = listOf("será \nchamada", "está \nsendo chamada", "está \nsendo chamado", "será \nchamado")
    var apontadorTexto by rememberSaveable { mutableIntStateOf(0) }
    var apontadorFinalDoTexto by rememberSaveable { mutableIntStateOf(0) }
    val corDesativado = Color(0xFF001F54)
    val corAtivado = Color.White
    var botoesVisiveis by rememberSaveable { mutableStateOf(true) }
    var tempoRestanteSegundos = 30
    var textoTemporizador by rememberSaveable { mutableStateOf("0:30") }
    val context = LocalContext.current

    // Verificar permissão de overlay
    val overlayPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { }
    )

    fun verificarPermissaoOverlay(context: Context): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(context)) {
            Toast.makeText(
                context,
                "Permissão necessária para mostrar informações durante chamadas",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                "package:${context.packageName}".toUri()
            )
            overlayPermissionLauncher.launch(intent)
            return false
        }
        return true
    }

    // Monitoramento do estado da chamada
    var phoneStateListener: PhoneStateListener? = null

    fun monitorarEstadoChamada(context: Context) {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        phoneStateListener = object : PhoneStateListener() {
            override fun onCallStateChanged(state: Int, phoneNumber: String?) {
                when (state) {
                    TelephonyManager.CALL_STATE_IDLE -> {
                        // A chamada terminou, parar o serviço de overlay
                        context.stopService(Intent(context, EmergencyOverlayService::class.java))
                    }
                    TelephonyManager.CALL_STATE_OFFHOOK -> {
                        // Chamada em andamento
                    }
                    TelephonyManager.CALL_STATE_RINGING -> {
                        // Telefone está tocando
                    }
                }
            }
        }

        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    fun pararMonitoramentoChamada(context: Context) {
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        phoneStateListener?.let {
            telephonyManager.listen(it, PhoneStateListener.LISTEN_NONE)
        }
        phoneStateListener = null
    }

    fun abrirDiscadorEmergencia(context: Context, tipoEmergencia: Int) {
        val numeroParaLigar = when (tipoEmergencia) {
            0 -> "192" // SAMU
            1 -> "190" // Polícia
            2 -> "193" // Bombeiros
            else -> ""
        }

        try {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroParaLigar")
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Não foi possível abrir o discador", Toast.LENGTH_LONG).show()
        }
    }

    fun fazerChamadaEmergencia(context: Context, tipoEmergencia: Int) {
        try {
            var numeroParaLigar = when (tipoEmergencia) {
                0 -> "192" // SAMU
                1 -> "190" // Polícia
                2 -> "193" // Bombeiros
                else -> ""
            }

            // Para testes, use um número real (remova esta linha em produção)
            numeroParaLigar = "11953966921" // Número para testes

            // Verificar permissão de overlay
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(context)) {
                Toast.makeText(context, "Permissão de overlay necessária", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${context.packageName}"))
                context.startActivity(intent)
                return
            }

            // Iniciar serviço de overlay
            val overlayIntent = Intent(context, EmergencyOverlayService::class.java).apply {
                putExtra("NUMERO", numeroParaLigar)
                putExtra("TIPO_EMERGENCIA", tipoEmergencia)
            }
            context.startService(overlayIntent)

            // Pequeno delay para garantir que o overlay seja criado
            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                try {
                    val callIntent = Intent(Intent.ACTION_CALL).apply {
                        data = "tel:$numeroParaLigar".toUri()
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(callIntent)
                } catch (e: Exception) {
                    Log.e("CHAMADA_DEBUG", "Erro ao fazer chamada: ${e.message}", e)
                    // Parar o serviço se a chamada falhar
                    context.stopService(Intent(context, EmergencyOverlayService::class.java))
                    abrirDiscadorEmergencia(context, tipoEmergencia)
                }
            }, 500) // Delay de 500ms

        } catch (e: Exception) {
            Log.e("CHAMADA_DEBUG", "Erro geral: ${e.message}", e)
            Toast.makeText(context, "Falha ao realizar chamada: ${e.message}", Toast.LENGTH_LONG).show()
            abrirDiscadorEmergencia(context, tipoEmergencia)
        }
    }
    fun enviarSmsEmergencia(context: Context, tipoEmergencia: Int) {
        try {
            val smsManager = SmsManager.getDefault()
            val numeroDestino = when (tipoEmergencia) {
                0 -> "192" // SAMU
                1 -> "190" // Polícia
                2 -> "193" // Bombeiros
                else -> ""
            }

            // Obter localização atual (simplificado)
            val localizacao = "Endereço não disponível"

            val mensagem = when (tipoEmergencia) {
                0 -> "EMERGÊNCIA MÉDICA: Preciso de uma ambulância em $localizacao"
                1 -> "EMERGÊNCIA POLICIAL: Preciso de ajuda em $localizacao"
                2 -> "EMERGÊNCIA BOMBEIROS: Preciso de ajuda em $localizacao"
                else -> "EMERGÊNCIA: Preciso de ajuda em $localizacao"
            }

            smsManager.sendTextMessage("+5511953966921", null, mensagem, null, null)

            Toast.makeText(
                context,
                "SMS de emergência enviado",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            Toast.makeText(
                context,
                "Falha ao enviar SMS: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun enviarSmsAlternativo(context: Context, tipoEmergencia: Int) {
        try {
            val numeroDestino = "11953966921" // Número de teste

            val localizacao = "Endereço não disponível"
            val mensagem = when (tipoEmergencia) {
                0 -> "EMERGÊNCIA MÉDICA: Preciso de uma ambulância em $localizacao"
                1 -> "EMERGÊNCIA POLICIAL: Preciso de ajuda em $localizacao"
                2 -> "EMERGÊNCIA BOMBEIROS: Preciso de ajuda em $localizacao"
                else -> "EMERGÊNCIA: Preciso de ajuda em $localizacao"
            }

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "smsto:$numeroDestino".toUri()
                putExtra("sms_body", mensagem)
            }

            context.startActivity(intent)
        } catch (e: Exception) {
            Log.e("SMS_DEBUG", "Erro ao iniciar Intent de SMS: ${e.message}", e)
            Toast.makeText(context, "Falha ao preparar SMS: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    val smsPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                enviarSmsEmergencia(context, apontadorTexto)
            } else {
                Toast.makeText(
                    context,
                    "Permissão para enviar SMS negada",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    )

    // Launcher para solicitar permissão
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                // Permissão concedida - fazer a ligação diretamente
                fazerChamadaEmergencia(context, apontadorTexto)
            } else {
                // Permissão negada - mostrar mensagem e usar discador como alternativa
                Toast.makeText(
                    context,
                    "Permissão negada. Usando discador.",
                    Toast.LENGTH_LONG
                ).show()
                abrirDiscadorEmergencia(context, apontadorTexto)
            }
        }
    )

    // Launcher para solicitar permissão de ANSWER_PHONE_CALLS
    val answerCallsPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                Toast.makeText(
                    context,
                    "Permissão para gerenciar chamadas concedida",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    context,
                    "Permissão para gerenciar chamadas negada. Algumas funcionalidades podem não funcionar.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    )

    // Efeito para o temporizador
    LaunchedEffect(Unit) {
        while (tempoRestanteSegundos > 0) {
            delay(1000)
            tempoRestanteSegundos--
            textoTemporizador = "0:${tempoRestanteSegundos.toString().padStart(2, '0')}"
        }
        botoesVisiveis = false // Esconde os botões quando o tempo acabar

        if (apontadorTexto == 1 || apontadorTexto == 0) {
            apontadorFinalDoTexto = 1
        } else {
            apontadorFinalDoTexto = 2
        }
    }

    // Monitore quando os botões se tornam invisíveis para solicitar permissão
    LaunchedEffect(botoesVisiveis) {
        if (!botoesVisiveis) {
            // Verificar permissão de overlay antes
            verificarPermissaoOverlay(context)

            // Solicitar permissões de chamada, SMS e ANSWER_PHONE_CALLS
            permissionLauncher.launch(Manifest.permission.CALL_PHONE)
            smsPermissionLauncher.launch(Manifest.permission.SEND_SMS)
            answerCallsPermissionLauncher.launch(Manifest.permission.ANSWER_PHONE_CALLS)
        }
    }

    // Limpar recursos quando a tela for desmontada
    DisposableEffect(Unit) {
        onDispose {
            pararMonitoramentoChamada(context)
            context.stopService(Intent(context, EmergencyOverlayService::class.java))
        }
    }

    // UI da tela
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF00041B),
                        Color(0xFF3F0001)
                    )
                )
            )
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "SOS Emergência",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontSize = 32.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(vertical = 39.dp),
        )

        Image(
            painter = painterResource(R.drawable.icone_de_alerta),
            contentDescription = "Ícone de Alerta",
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = textos[apontadorTexto] + finalDoTexto[apontadorFinalDoTexto],
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontWeight = FontWeight(400),
            color = Color(0xFFFFFFFF),
            modifier = Modifier
                .padding(top = 26.dp)
                .width(241.dp)
                .height(104.dp),
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(100.dp))

        if (botoesVisiveis) {
            Text(
                text = "Trocar de agente",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.archivo)),
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 14.dp)
            ) {
                Button(
                    onClick = { apontadorTexto = 0; apontadorFinalDoTexto = 0 },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTexto != 0) corDesativado else Color.White
                    ),
                    modifier = Modifier
                        .height(56.dp)
                        .shadow(elevation = 4.dp),
                    contentPadding = PaddingValues(
                        horizontal = 11.dp,
                        vertical = 12.dp
                    ),
                ) {
                    Text(
                        "Médico",
                        color = if (apontadorTexto != 0) Color.White else Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black))
                    )
                }

                Button(
                    onClick = { apontadorTexto = 1; apontadorFinalDoTexto = 0 },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTexto != 1) corDesativado else corAtivado
                    ),
                    modifier = Modifier
                        .height(56.dp)
                        .shadow(elevation = 4.dp),
                    contentPadding = PaddingValues(
                        horizontal = 11.dp,
                        vertical = 12.dp
                    ),
                ) {
                    Text(
                        "Polícia",
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        color = if (apontadorTexto != 1) Color.White else Color.Black
                    )
                }

                Button(
                    onClick = { apontadorTexto = 2; apontadorFinalDoTexto = 3 },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTexto != 2) corDesativado else corAtivado
                    ),
                    contentPadding = PaddingValues(
                        horizontal = 4.dp,
                        vertical = 12.dp
                    ),
                    modifier = Modifier
                        .height(56.dp)
                        .shadow(elevation = 4.dp),
                ) {
                    Text(
                        text = "Bombeiros",
                        color = if (apontadorTexto != 2) Color.White else Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black))
                    )
                }
            }

            Button(
                onClick = { apontadorTexto = 2; apontadorFinalDoTexto = 4 },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, bottom = 20.dp),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(
                    "Cancelar",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),
                )
            }
        } else {
            Spacer(Modifier.height(200.dp))
        }
    }
}

// Serviço de overlay para manter o contexto durante chamadas


//
// <?xml version="1.0" encoding="utf-8"?>
// <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//     android:layout_width="match_parent"
//     android:layout_height="wrap_content"
//     android:orientation="vertical"
//     android:background="#CC001F54"
//     android:padding="16dp">
//
//     <TextView
//         android:id="@+id/textoServicoEmergencia"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:text="Serviço de Emergência"
//         android:textColor="#FFFFFF"
//         android:textSize="18sp"
//         android:textStyle="bold"
//         android:gravity="center" />
//
//     <TextView
//         android:id="@+id/textoStatusChamada"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:text="Chamada em andamento..."
//         android:textColor="#FFFFFF"
//         android:textSize="16sp"
//         android:gravity="center"
//         android:layout_marginTop="8dp" />
//
//     <Button
//         android:id="@+id/botaoVoltarApp"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:text="Voltar para o aplicativo"
//         android:layout_marginTop="8dp"
//         android:backgroundTint="#FFFFFF"
//         android:textColor="#001F54" />
// </LinearLayout>

@Preview(showBackground = true)
@Composable
fun PreviewPoliceEmergencyScreen() {
    PoliceEmergencyScreen()
}

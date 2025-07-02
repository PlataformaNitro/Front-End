import android.Manifest
import android.content.Context
import android.telephony.SmsManager
import android.content.Intent
import android.net.Uri
import android.util.Log
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
    var textotemporizador by rememberSaveable { mutableStateOf("0:30") }
    val context = LocalContext.current

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
              //  enviarSmsAlternativo(context, apontadorTexto) // Envia SMS alternativo se necessário

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
                // Permissão concedida - fazer a ligação
                var numeroParaLigar = when (apontadorTexto) {
                    0 -> "192" // SAMU
                    1 -> "190" // Polícia
                    2 -> "193" // Bombeiros
                    else -> ""
                }


                if (numeroParaLigar.isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_CALL).apply {
                        data = Uri.parse("tel:11953966921")
                    }
                    context.startActivity(intent)
                }
            } else {
                // Permissão negada - mostrar mensagem e usar discador como alternativa
                Toast.makeText(
                    context,
                    "Permissão negada. Usando discador.",
                    Toast.LENGTH_LONG
                ).show()

                // Use o discador como alternativa
                val numeroParaLigar = when (apontadorTexto) {
                    0 -> "192" // SAMU
                    1 -> "190" // Polícia
                    2 -> "193" // Bombeiros
                    else -> ""
                }

                if (numeroParaLigar.isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$numeroParaLigar")
                    }
                    context.startActivity(intent)
                }
            }
        }
    )

    LaunchedEffect(Unit) {
        while (tempoRestanteSegundos > 0) {
            delay(1000)
            tempoRestanteSegundos--
            textotemporizador = "0:${tempoRestanteSegundos.toString().padStart(2, '0')}"
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
            permissionLauncher.launch(Manifest.permission.CALL_PHONE)
            smsPermissionLauncher.launch(Manifest.permission.SEND_SMS)
        }
    }

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

@Preview(showBackground = true)
@Composable
fun PreviewPoliceEmergencyScreen() {
    PoliceEmergencyScreen()
}
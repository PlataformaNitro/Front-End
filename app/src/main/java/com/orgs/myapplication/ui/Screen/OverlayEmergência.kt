package com.example.arquivomobileoficialnitro.ui.screen

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.telephony.TelephonyManager
import android.view.Gravity
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import com.orgs.myapplication.R

// Classe auxiliar para gerenciar o ciclo de vida no serviço
private class ServiceLifecycleOwner : LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    private val lifecycleRegistry = LifecycleRegistry(this)
    private val store = ViewModelStore()
    private val savedStateRegistryController = SavedStateRegistryController.create(this)

    override val lifecycle: Lifecycle
        get() = lifecycleRegistry

    override val viewModelStore: ViewModelStore
        get() = store

    override val savedStateRegistry: SavedStateRegistry
        get() = savedStateRegistryController.savedStateRegistry

    init {
        savedStateRegistryController.performRestore(null)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    fun resume() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    fun destroy() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        store.clear()
    }
}

class EmergencyOverlayService : Service() {
    private var windowManager: WindowManager? = null
    private var overlayView: ComposeView? = null
    private var numero: String = ""
    private var tipoEmergencia: Int = 0
    private val callStateReceiver = CallStateReceiver()
    private var lifecycleOwner: ServiceLifecycleOwner? = null

    // Variáveis de estado para o overlay
    private var apontadorTexto by mutableIntStateOf(1) // Inicia com polícia selecionada
    private var apontadorFinalDoTexto by mutableIntStateOf(0)

    // Cores para os botões
    private val corAtivado = Color.White
    private val corDesativado = Color(0xFF666666)

    // Textos para exibição
    private val textos = listOf(
        "Ligando para SAMU",
        "Ligando para Polícia",
        "Ligando para Bombeiros"
    )

    private val finalDoTexto = listOf(
        " (192)",
        " (190)",
        " (193)",
        " (193)",
        ""
    )

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        lifecycleOwner = ServiceLifecycleOwner()

        val intentFilter = IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED)
        registerReceiver(callStateReceiver, intentFilter)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            numero = it.getStringExtra("NUMERO") ?: ""
            tipoEmergencia = it.getIntExtra("TIPO_EMERGENCIA", 0)
            mostrarOverlay()
            lifecycleOwner?.resume()
        }
        return START_STICKY
    }

    private fun mostrarOverlay() {
        try {
            overlayView?.let { windowManager?.removeView(it) }
            val owner = lifecycleOwner ?: return

            overlayView = ComposeView(this).apply {
                // Define os proprietários do ciclo de vida, estado e viewmodel
                setViewTreeLifecycleOwner(owner)
                setViewTreeViewModelStoreOwner(owner)
                setViewTreeSavedStateRegistryOwner(owner)

                setContent {
                    EmergencyOverlayContent(
                        numero = numero,
                        tipoEmergencia = tipoEmergencia,
                        onVoltarClick = {
                            val intent = packageManager.getLaunchIntentForPackage(packageName)
                            intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                            stopSelf() // Encerra o serviço ao voltar para o app
                        }
                    )
                }
            }

            val layoutType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                @Suppress("DEPRECATION")
                WindowManager.LayoutParams.TYPE_PHONE
            }

            val params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                layoutType,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT
            ).apply {
                gravity = Gravity.TOP
            }

            windowManager?.addView(overlayView, params)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Composable
    private fun EmergencyOverlayContent(
        numero: String,
        tipoEmergencia: Int,
        onVoltarClick: () -> Unit
    ) {
        // Estado local para controle dos botões
        var apontadorTextoLocal by remember { mutableIntStateOf(tipoEmergencia) }
        var apontadorFinalLocal by remember { mutableIntStateOf(if (tipoEmergencia == 2) 3 else 0) }

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
                .padding(16.dp),
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
                text = textos[apontadorTextoLocal] + finalDoTexto[apontadorFinalLocal],
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
                    onClick = {
                        apontadorTextoLocal = 0
                        apontadorFinalLocal = 0
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTextoLocal != 0) corDesativado else Color.White
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
                        color = if (apontadorTextoLocal != 0) Color.White else Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black))
                    )
                }

                Button(
                    onClick = {
                        apontadorTextoLocal = 1
                        apontadorFinalLocal = 0
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTextoLocal != 1) corDesativado else corAtivado
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
                        color = if (apontadorTextoLocal != 1) Color.White else Color.Black
                    )
                }

                Button(
                    onClick = {
                        apontadorTextoLocal = 2
                        apontadorFinalLocal = 3
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTextoLocal != 2) corDesativado else corAtivado
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
                        color = if (apontadorTextoLocal != 2) Color.White else Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black))
                    )
                }
            }

            Button(
                onClick = onVoltarClick,
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, bottom = 20.dp),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text(
                    "Voltar ao App",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),
                )
            }
        }
    }

    inner class CallStateReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
                val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
                if (state == TelephonyManager.EXTRA_STATE_IDLE) {
                    stopSelf()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            unregisterReceiver(callStateReceiver)
            overlayView?.let { windowManager?.removeView(it) }
            overlayView = null
            lifecycleOwner?.destroy() // Destroi o ciclo de vida personalizado
            lifecycleOwner = null
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
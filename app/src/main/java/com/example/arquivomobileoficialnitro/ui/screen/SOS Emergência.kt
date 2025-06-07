import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

@Composable
fun PoliceEmergencyScreen(paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val textos = listOf(
        "Uma \nambulância ","Uma \nautoridade policial ","Um \ncaminhão de bombeiro "
    )
    var finalDoTexto = listOf("será \nchamada", "está \nsendo chamada", "está \nsendo chamado", "será \nchamado")
    var apontadorTexto by rememberSaveable { mutableIntStateOf(0) }
    var apontadorFinalDoTexto by rememberSaveable { mutableIntStateOf(0) }
    val corDesativado = Color(0xFF001F54) // Azul escuro
    val corAtivado = Color.White
    var botoesVisiveis by rememberSaveable() {  mutableStateOf(true) }
    var tempoRestanteSegundos = 30
    var textotemporizador by rememberSaveable { mutableStateOf("0:30") }

    LaunchedEffect(Unit) {

        while (tempoRestanteSegundos > 0) {
            delay(1000) // Espera 1 segundo
            tempoRestanteSegundos--
        }
        botoesVisiveis = false // Esconde os botões quando o tempo acabar
        if( apontadorTexto == 1 || apontadorTexto == 0){
        apontadorFinalDoTexto = 1
    }else{
        apontadorFinalDoTexto = 2
    }
        }

    Column(
            modifier = Modifier
                .fillMaxSize()
                .background( brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF00041B), // Dark Purple
                        Color(0xFF3F0001)  // Lighter Purple
                    )
                ))
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
                painter = painterResource(R.drawable.icone_de_alerta), // Use your own icon resource
                contentDescription = "Ícone de Alerta",
                modifier = Modifier.size(100.dp)
            )
                Text(
                    text = textos[apontadorTexto] + finalDoTexto[apontadorFinalDoTexto],
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.archivo_black)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier.padding(top = 26.dp)
                            .width(241.dp)
                            .height(104.dp),

                        textAlign = TextAlign.Center,
                )

Spacer(Modifier.height(100.dp))
        if(botoesVisiveis){
            Text(
                text = "Trocar de agente",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.archivo)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                    modifier =   Modifier.padding(top = 20.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(horizontal = 14.dp)
            ) {
                Button(
                    onClick = { apontadorTexto = 0;apontadorFinalDoTexto = 0 },
                    shape = RoundedCornerShape(10.dp), // Ajuste o raio para o arredondamento desejado
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (apontadorTexto != 0) corDesativado else Color.White // Um azul escuro, ajuste conforme necessário
                    ),
                    modifier = Modifier.height(56.dp)
                        .shadow(elevation = 4.dp),
                    contentPadding = PaddingValues(
                        horizontal = 11.dp,
                        vertical = 12.dp
                    ),

                ) {
                    Text(
                        "Médico", color = if(apontadorTexto != 0) Color.White else Color.Black,

                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.archivo_black))

                    )
                }
                Button(
                    onClick = { apontadorTexto = 1; apontadorFinalDoTexto = 0 },
                    shape = RoundedCornerShape(10.dp), // Ajuste o raio para o arredondamento desejado
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if(apontadorTexto != 1) corDesativado else corAtivado// Um azul escuro, ajuste conforme necessário
                    ),
                    modifier = Modifier.height(56.dp)
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
                        color = if(apontadorTexto !=1) Color.White else Color.Black // Muda a cor do texto dependendo do estado do botão,

                        )
                }
                Button (

                    onClick = { apontadorTexto = 2; apontadorFinalDoTexto = 3 },
                    shape = RoundedCornerShape(10.dp), // Ajuste o raio para o arredondamento desejado
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if(apontadorTexto != 2)  corDesativado else corAtivado// O mesmo azul escuro, ajuste se necessário,,
                    ),
                    contentPadding = PaddingValues(
                        horizontal = 4.dp,
                        vertical = 12.dp
                    ),
                    modifier = Modifier.height(56.dp)
                            .shadow(elevation = 4.dp)
                // Ajuste o padding se necessário
                ) {
                    Text(
                        text = "Bombeiros", // Texto alterado
                        color = if(apontadorTexto != 2) Color.White else Color.Black, // Muda a cor do texto dependendo do estado do botão
                        fontSize = 20.sp, // Ajuste o tamanho da fonte se necessário
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
                    .padding( 10.dp, bottom = 20.dp),
                contentPadding = PaddingValues(vertical = 15.dp)
            ) {
                Text("Cancelar", color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.archivo_black)),
                    fontWeight = FontWeight(400),)
            }

        }else(
                Spacer(Modifier.height(200.dp))
                )
}
}

@Preview(showBackground = true)
@Composable
fun PreviewPoliceEmergencyScreen() {
    PoliceEmergencyScreen()
    }
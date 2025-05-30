import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.components.util.BackgroundSecundario

@Composable
fun BoasVindasScreen(modifier: Modifier = Modifier, navController: NavController? = null) {
    Box {
        BackgroundSecundario()

        // Apenas uma imagem (remova as duplicadas se não forem necessárias)
        Image(
            painter = painterResource(id = R.drawable.image_16_1_),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .alpha(0.8f),
            contentScale = ContentScale.FillWidth
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HeaderBoasVindas(
                Modifier.padding(bottom = 211.dp, start = 14.dp, end = 14.dp)
            )

            BotaoDeEntrada(
                texto = "entrar",
                containerColor = Color(0xB2111F21),
                onClick = {
                    navController?.navigate("Login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )

            Text("ou", Modifier.padding(vertical = 17.dp), color = Color.White)

            BotaoDeEntrada(
                texto = "cadastrar",
                containerColor = Color(red = 0x5D, green = 0x7F, blue = 0xA5, alpha = 0xB2),
                onClick = {
                    navController?.navigate("cadastro") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
    }
}


@Preview
@Composable
private fun BoasVindasScreenPreview() {
    BoasVindasScreen()
}
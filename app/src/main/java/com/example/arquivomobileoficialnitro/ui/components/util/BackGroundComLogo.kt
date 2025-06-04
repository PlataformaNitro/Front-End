import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.arquivomobileoficialnitro.R

@Composable
fun TesteScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.main_2_),
        contentDescription = "uma tela com fundo azul icones de montanha em baixo e a logo nitro em cima",
        Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun TesteScreenPreview() {
    TesteScreen()
}
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SloganTexto(modifier: Modifier = Modifier) {
    Text(
        text = "O Caminho Certo para quem vive sobre duas rodas!",
        fontSize = 25.sp, // Tamanho do texto
        fontWeight = FontWeight.Bold, // Peso da fonte
        color = Color.White, // Cor do texto
        textAlign = TextAlign.Center,
        letterSpacing = 1.5.sp, // Espaçamento entre as letras
        modifier = modifier
    )
}

@Preview
@Composable
private fun SloganTextoPreview() {
  SloganTexto()
}
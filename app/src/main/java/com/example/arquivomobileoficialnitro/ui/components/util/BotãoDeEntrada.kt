import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BotaoDeEntrada(
    texto: String,
    containerColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(width = 347.dp, height = 59.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10.dp),
                ambientColor = Color(0x40000000), // #00000040
                spotColor = Color(0x40000000)
            ),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor // #111F21B2
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp) // porque usamos shadow personalizado
    ) {

        Text(
            text = texto,
            fontFamily = archivoBlack,
            fontWeight = FontWeight.Normal, // 400
            fontSize = 24.sp,
            lineHeight = 24.sp, // 100% do fontSize
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BotaoCustomizadoPreview() {
    BotaoDeEntrada(texto = "Clique aqui", containerColor = Color(0xB2111F21))
}

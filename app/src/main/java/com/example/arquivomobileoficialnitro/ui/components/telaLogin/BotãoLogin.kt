import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment

@Composable
fun BotaoLogin(modifier: Modifier = Modifier) {
    Button(
        onClick = { /* ação de login */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF87CEEB) // cor de fundo azul claro
        ),
        shape = RoundedCornerShape(25.dp), // borda arredondada
        modifier = modifier
            .width(289.dp)
            .height(59.dp)
    ) {
        Text(
            text = "Entrar",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBotaoEntrar() {

        BotaoLogin()

}

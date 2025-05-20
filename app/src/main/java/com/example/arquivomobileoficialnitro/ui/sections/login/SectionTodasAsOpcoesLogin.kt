import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SectionTodasAsOpcoesLogin(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(599.dp)
            .clip(RoundedCornerShape(topStart = 70.dp, topEnd = 70.dp))
            .background(Color(0x440A1F44)) // Cor com transparência
            .padding(45.dp,60.dp,45.dp,96.dp) // espaço interno opcional
    ) {
        SectionOpcoesLogin(Modifier.padding(bottom = 37.dp))
        SectionInputsLogin(Modifier.padding(bottom = 17.dp))
        BotaoLogin()
    }
}

@Preview(showBackground = true)
@Composable
private fun SectionTodasAsOpcoesLoginPreview() {

        SectionTodasAsOpcoesLogin()

}

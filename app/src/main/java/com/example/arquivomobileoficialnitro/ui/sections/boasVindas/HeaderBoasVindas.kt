import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun HeaderBoasVindas(modifier: Modifier = Modifier) {
    val listFrasesBoasVindas = listOf(
        "Nitro, sua ferramenta para viagens seguras e confortáveis sem qualquer tipo de preocupação",
        "Feito por profissionais, para profissionais. Sua viagem fácil na ponta do dedo",
        "Não se esqueça de abastecer assim que sairmos, é muito importante estar preparado"
    )

    var currentIndex by remember { mutableStateOf(0) }

    // Muda a frase a cada 5 segundos
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            currentIndex = (currentIndex + 1) % listFrasesBoasVindas.size
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextoBoasVindas(
            color = Color.White,
            textBoasVindas = listFrasesBoasVindas[currentIndex]
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pontinhos
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            listFrasesBoasVindas.indices.forEach { index ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(
                            color = if (index == currentIndex) Color.White else Color.Gray,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFBB86FC)
@Composable
private fun HeaderBoasVindasPreview() {
    HeaderBoasVindas()
}

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TelaBusca(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        Modifier.padding()
            .verticalScroll(scrollState)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF021030), // Azul escuro
                        Color(0xFF014677)  // Azul médio
                    )
                )
            )
            .alpha(0.8f), // Define a opacidade para 30%
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Logo()
        Header()
        Search(text = "", onTextChange = {})
        SectionBotoesDeFiltro()
        Recomendadas()
        TituloContainer("Talvez você conheça", "Ver mais")
        SectionPessoasRecomendas()
        TituloContainer("Eventos Acontecendo", "ver mais")
        SectionCardHome()
    }
}

@Preview
@Composable
private fun TelaBuscaPreview() {
    TelaBusca()
}
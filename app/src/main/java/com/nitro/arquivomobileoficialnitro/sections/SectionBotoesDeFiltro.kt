import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nitro.arquivomobileoficialnitro.components.BotoesFiltro

@Composable
fun SectionBotoesDeFiltro(modifier: Modifier = Modifier.fillMaxWidth()) {
    Row(horizontalArrangement = Arrangement.spacedBy(11.dp)){
        BotoesFiltro(text = "proximo")
        BotoesFiltro(text = "populares")
        BotoesFiltro(text = "recentes")
        BotoesFiltro(text = "recentes")
    }
}

@Preview(showBackground = true)
@Composable
private fun SectionBotoesDeFiltroPreview() {

    SectionBotoesDeFiltro()
}
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EventoScreen(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp),modifier = modifier.verticalScroll(rememberScrollState())){
        Spacer(Modifier)
        EventoSection(listaDeEventos = sampleEvents)
        EventoSection(listaDeEventos = sampleEvents)
        EventoSection(listaDeEventos = sampleEvents)
        Spacer(Modifier)
    }
}

@Preview
@Composable
private fun EventoScreenPreview() {
    EventoScreen()
}
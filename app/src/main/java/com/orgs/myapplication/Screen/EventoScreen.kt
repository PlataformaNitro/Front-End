import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orgs.myapplication.Model.Evento

@Composable
fun EventoScreen(modifier: Modifier = Modifier, sections: Map<String, List<Evento>>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier)
        for (section in sections) {
            EventoSection(title = section.key, listaDeEventos = section.value)
        }
        Spacer(Modifier)
    }
}

@Preview
@Composable
private fun EventoScreenPreview() {
    EventoScreen(sections = mapOf(
        "Próximos Eventos" to sampleEvents,
        "Por Proximidade" to sampleEvents)
    )
}
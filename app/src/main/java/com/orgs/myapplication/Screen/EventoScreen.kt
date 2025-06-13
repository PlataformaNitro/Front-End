import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orgs.myapplication.Model.Evento
import kotlin.collections.mapOf

class EventoScreenUiState(
    val searchText: String = "",
    val sections: Map<String, List<Evento>> = emptyMap(),
    val eventosProucurados: List<Evento> = emptyList(),
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }

}

@Composable
fun EventoScreen(eventos: List<Evento>) {
    val sections = mapOf(
        "todos os eventos" to eventos,
        "Próximos Eventos" to sampleEvents,
        "Por Proximidade" to sampleEventsProximos
    )

    var text by remember {
        mutableStateOf("")
    }

    fun containsTitulo(): (Evento) -> Boolean = { evento ->
        evento.titulo.contains(text, ignoreCase = true)
    }

    val eventosProucurados = remember(eventos, text) {
        if (text.isNotBlank()) {
            sampleEvents.filter(containsTitulo()) + eventos.filter(containsTitulo())
        } else {
            emptyList()
        }
    }

    val state = remember(eventos,text) {
        EventoScreenUiState(
            sections = sections,
            eventosProucurados = eventosProucurados,
            searchText = text,
            onSearchChange = {text = it}
        )
    }
    EventoScreen(state = state)
}

@Composable
fun EventoScreen(
    modifier: Modifier = Modifier,
    state: EventoScreenUiState = EventoScreenUiState()
) {

    val sections = state.sections
    var text = state.searchText
    val eventosProucurados = state.eventosProucurados

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = state.onSearchChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text("Nome do evento") }
        )
        Spacer(Modifier)
        if (state.isShowSections()) {
            for (section in sections) {
                EventoSection(title = section.key, listaDeEventos = section.value)
            }
        } else {
            for (evento in eventosProucurados) {
                EventoItem(modifier = Modifier.padding(start = 16.dp), evento = evento)
            }
        }
        Spacer(Modifier)
    }
}

@Preview
@Composable
private fun EventoScreenPreview() {
    EventoScreen(state = EventoScreenUiState(sections = sampleSection))
}

@Preview
@Composable
private fun EventoScreenPreviewComTextoPesquisado() {
    EventoScreen(state = EventoScreenUiState(searchText = "e", sections = sampleSection))
}
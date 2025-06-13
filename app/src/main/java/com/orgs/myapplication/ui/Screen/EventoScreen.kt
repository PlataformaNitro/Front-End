import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orgs.myapplication.Model.Evento
import kotlin.collections.iterator
import kotlin.collections.mapOf


@Composable
fun EventoScreen(viewModel: EventosScreenViewModel,) {
    val state = viewModel.uiState
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
        SearchText(text = text, state = state)
        Spacer(Modifier)
        if (state.isShowSections()) {
            for (section in sections) {
                EventoSection(title = section.key, listaDeEventos = section.value)
            }
        } else {
            for (evento in eventosProucurados) {
                CardItemEvento(modifier = Modifier.padding(start = 16.dp), evento = evento)
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
    EventoScreen(state = EventoScreenUiState(searchText = "ev", sections = sampleSection))
}
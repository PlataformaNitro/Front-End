import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.orgs.myapplication.Model.Evento
import kotlin.collections.mapOf

class EventosScreenViewModel: ViewModel(){
    private val dao = EventDao()

    var uiState: EventoScreenUiState by mutableStateOf(
        EventoScreenUiState(
        sections = mapOf(
            "todos os eventos" to dao.eventos(),
        "Próximos Eventos" to sampleEvents,
        "Por Proximidade" to sampleEventsProximos
    ),
        onSearchChange = {
            uiState = uiState.copy(searchText = it, eventosProucurados = eventosProucurados(it))
        }
    ))
     private set


    private fun containsTitulo(): (Evento) -> Boolean = { evento ->
        evento.titulo.contains(uiState.searchText, ignoreCase = true) || evento.descricao.contains(uiState.searchText, ignoreCase = true)
    }

    private fun eventosProucurados(text:String): List<Evento> {
       return if (text.isNotBlank()) {
            sampleEvents.filter(containsTitulo()) + dao.eventos().filter(containsTitulo())
        } else {
            emptyList()
        }
    }
}
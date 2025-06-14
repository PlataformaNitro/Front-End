import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orgs.myapplication.Model.Evento
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.mapOf

class EventosScreenViewModel: ViewModel(){
    private val dao = EventDao()

   private var _uiState: MutableStateFlow<EventoScreenUiState> = MutableStateFlow(
        EventoScreenUiState())

     val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(onSearchChange = {
                _uiState.value = _uiState.value.copy(searchText = it, eventosProucurados = eventosProucurados(it))
            })
        }
        viewModelScope.launch {
            dao.eventos().collect { eventos -> _uiState.value = _uiState.value.copy(
                sections = mapOf(
                    "todos os eventos" to eventos,
                    "Próximos Eventos" to sampleEvents,
                    "Por Proximidade" to sampleEventsProximos
                ),
                eventosProucurados = eventosProucurados(_uiState.value.searchText)
            )}
        }

    }

    private fun containsTitulo(): (Evento) -> Boolean = { evento ->
        evento.titulo.contains(_uiState.value.searchText, ignoreCase = true) || evento.descricao.contains(_uiState.value.searchText, ignoreCase = true)
    }

    private fun eventosProucurados(text:String): List<Evento> {
       return if (text.isNotBlank()) {
            sampleEvents.filter(containsTitulo()) + dao.eventos().value.filter(containsTitulo())
        } else {
            emptyList()
        }
    }

}
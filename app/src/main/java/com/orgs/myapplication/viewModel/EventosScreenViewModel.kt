import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.Model.MotoClube
import com.orgs.myapplication.Model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventosScreenViewModel : ViewModel() {
    private val dao = EventDao()

    private var _uiState: MutableStateFlow<EventoScreenUiState> = MutableStateFlow(EventoScreenUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange = { query ->
                    _uiState.value = _uiState.value.copy(
                        searchText = query,
                        eventosProucurados = eventosProucurados(query),
                        usuariosProucurados = usuariosProucurados(query),
                        clubesProucurados = clubesProucurados(query)
                    )
                }
            )
        }

        viewModelScope.launch {
            dao.eventos().collect { eventos ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "todos os eventos" to eventos,
                        "Próximos Eventos" to sampleEvents,
                        "Por Proximidade" to sampleEventsProximos
                    ),
                    eventosProucurados = eventosProucurados(_uiState.value.searchText),
                    usuariosProucurados = usuariosProucurados(_uiState.value.searchText),
                    clubesProucurados = clubesProucurados(_uiState.value.searchText)
                )
            }
        }
    }

    private fun containsTitulo(): (Evento) -> Boolean = { evento ->
        evento.titulo.contains(_uiState.value.searchText, ignoreCase = true) ||
                evento.descricao.contains(_uiState.value.searchText, ignoreCase = true)
    }

    private fun eventosProucurados(text: String): List<Evento> {
        return if (text.isNotBlank()) {
            sampleEvents.filter(containsTitulo()) + dao.eventos().value.filter(containsTitulo())
        } else {
            emptyList()
        }
    }

    private fun usuariosProucurados(text: String): List<User> {
        return if (text.isNotBlank()) {
            sampleUsers.filter {
                it.nome.contains(text, ignoreCase = true)
            }
        } else {
            emptyList()
        }
    }

    private fun clubesProucurados(text: String): List<MotoClube> {
        return if (text.isNotBlank()) {
            sampleMotoClubes.filter {
                it.nome.contains(text, ignoreCase = true)
            }
        } else {
            emptyList()
        }
    }
}

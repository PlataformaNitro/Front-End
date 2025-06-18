import com.orgs.myapplication.Model.User
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.Model.MotoClube

data class EventoScreenUiState(
    val searchText: String = "",
    val sections: Map<String, List<Evento>> = emptyMap(),
    val eventosProucurados: List<Evento> = emptyList(),
    val usuariosProucurados: List<User> = emptyList(),
    val clubesProucurados: List<MotoClube> = emptyList(),
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }
}

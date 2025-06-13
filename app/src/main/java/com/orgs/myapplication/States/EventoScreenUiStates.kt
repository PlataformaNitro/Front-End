import com.orgs.myapplication.Model.Evento

data class EventoScreenUiState(
    val searchText: String = "",
    val sections: Map<String, List<Evento>> = emptyMap(),
    val eventosProucurados: List<Evento> = emptyList(),
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSections(): Boolean {
        return searchText.isBlank()
    }

}
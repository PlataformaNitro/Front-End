import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EventosScreenViewModel: ViewModel(){
    var uiState by mutableStateOf(EventoScreenUiState())
     private set
}
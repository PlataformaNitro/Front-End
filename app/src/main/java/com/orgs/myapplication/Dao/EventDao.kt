import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.orgs.myapplication.Model.Evento
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EventDao{
    companion object{
        private val eventos = MutableStateFlow<List<Evento>>(emptyList())
    }

    fun eventos() = eventos.asStateFlow()

    fun save(evento: Evento){
        Log.i("EventDao", "Salvando evento: $evento")
        eventos.value += evento
    }
}
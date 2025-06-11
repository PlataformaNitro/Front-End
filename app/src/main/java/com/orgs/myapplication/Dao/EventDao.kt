import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.orgs.myapplication.Model.Evento

class EventDao{
    companion object{
        private val eventos = mutableStateListOf<Evento>(*sampleEvents.toTypedArray())
    }

    fun eventos() = eventos.toList()

    fun save(evento: Evento){
        Log.i("EventDao", "Salvando evento: $evento")
        eventos.add(evento)
    }
}
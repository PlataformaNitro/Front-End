import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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

@Composable
fun EventoScreen(modifier: Modifier = Modifier, sections: Map<String, List<Evento>>) {
    var text by remember { mutableStateOf("") }
    var eventosProucurados = remember(text){
        if(text.isNotBlank()){
            sampleEvents.filter {evento -> evento.titulo.contains(text,ignoreCase = true) }
        }else{
            emptyList()
        }
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newValue -> text = newValue },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            label = { Text("Nome do evento") }
        )
        Spacer(Modifier)
        if(text.isBlank()){
            for (section in sections) {
                EventoSection(title = section.key, listaDeEventos = section.value)
            }
        }else{
            for(evento in eventosProucurados){
                EventoItem(modifier = Modifier.padding(start = 16.dp), evento = evento)
            }
        }
        Spacer(Modifier)
    }
}

@Preview
@Composable
private fun EventoScreenPreview() {
    EventoScreen(
        sections = mapOf(
            "Próximos Eventos" to sampleEvents,
            "Por Proximidade" to sampleEvents
        )
    )
}
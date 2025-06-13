import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.orgs.myapplication.Model.Evento

@Composable
fun EventoItem(modifier: Modifier = Modifier,evento:Evento) {
    Column {
        Text(modifier = modifier, text = evento.titulo)
        Text(modifier = modifier, text = evento.descricao, color = Color.Red)
    }
}

@Preview
@Composable
private fun EventoItemPreview() {
    EventoItem(evento = Evento("Evento 1"))
}
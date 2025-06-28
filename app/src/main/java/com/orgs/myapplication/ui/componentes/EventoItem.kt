import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.R

@Composable
fun EventoItem(
    modifier: Modifier = Modifier,
    evento: Evento,
    larguraTexto: Dp = 130.dp
) {
    var mostrarDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
            .background(Color(0xFF162A45))
            .padding(vertical = 14.dp, horizontal = 5.dp)
            .width(243.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { mostrarDialog = true } // 👉 clique mostra modal
    ) {
        Row {
            Image(
                painter = painterResource(evento.imagem),
                contentDescription = "Imagem do evento",
                modifier = Modifier
                    .height(180.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .width(larguraTexto)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = evento.titulo,
                    modifier = Modifier.padding(top = 10.dp, start = 8.dp),
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = evento.descricao,
                    modifier = Modifier.padding(top = 11.dp, start = 8.dp),
                    color = Color.Red,
                    fontSize = 13.sp,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    if (mostrarDialog) {
        Dialog(onDismissRequest = { mostrarDialog = false }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
                    .background(Color(0xFF162A45), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(evento.imagem),
                        contentDescription = "Imagem ampliada",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = evento.titulo,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = evento.descricao,
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { mostrarDialog = false },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Fechar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EventoItemPreview() {
    EventoItem(evento = Evento(titulo = "Evento 1", descricao = "Descrição completa do evento. Detalhes completos para mostrar no modal."), larguraTexto = 130.dp)
}

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.Model.MotoClube
import com.orgs.myapplication.R

@Composable
fun MotoCLubeItem(modifier: Modifier = Modifier, motoClube: MotoClube,larguraTexto:Dp = 100.dp) {
    Box(modifier = modifier
        .background(Color(0xFF162A45))
        .padding(vertical = 14.dp, horizontal = 5.dp)
        .width(243.dp)){
        Row() {
            Image(
                painter = painterResource(motoClube.imagem), contentDescription = motoClube.nome,
                Modifier.height(180.dp).width(120.dp), contentScale = ContentScale.Crop
            )
            Column(Modifier.width(larguraTexto)) {
                Text(text = motoClube.nome, modifier.padding(top = 10.dp, start = 8.dp))
                Text(
                    text = motoClube.descricao,
                    modifier = modifier.padding(top = 11.dp, start = 8.dp),
                    color = Color.Red
                )
            }
            Icon(
                Icons.Default.MoreVert,
                contentDescription = "opções",
                modifier = Modifier.padding(top = 10.dp),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun EventoItemPreview() {
    EventoItem(evento = Evento(titulo = "Evento 1"))
}
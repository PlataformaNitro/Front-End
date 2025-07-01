import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.Model.MotoClube

@Composable
fun MotoCLubeItem(
    modifier: Modifier = Modifier,
    motoClube: MotoClube,
    larguraTexto: Dp = 100.dp,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(Color(0xFF162A45))
            .padding(vertical = 14.dp, horizontal = 5.dp)
            .width(243.dp)
            .clickable { onClick() } // Aqui adiciona o clique
    ) {
        Row() {
            Image(
                painter = painterResource(motoClube.imagem),
                contentDescription = motoClube.nome,
                modifier = Modifier
                    .height(180.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(Modifier.width(larguraTexto)) {
                Text(
                    text = motoClube.nome,
                    modifier = Modifier.padding(top = 10.dp, start = 8.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = motoClube.descricao,
                    modifier = Modifier.padding(top = 11.dp, start = 8.dp),
                    color = Color.Red,
                    fontSize = 13.sp,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
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
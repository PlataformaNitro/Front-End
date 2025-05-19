import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nitro.arquivomobileoficialnitro.R
import com.nitro.arquivomobileoficialnitro.ui.theme.archivoBlack

@Composable
fun Recomendadas(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .width(367.dp)
        .height(182.dp)
        .clip(RoundedCornerShape(25.dp))) {
        Image(
            painter = painterResource(id = R.drawable.grades),
            "imagem de motos",
            modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.recomendadas),
            "imagem de motos",
            modifier
                .fillMaxSize()
                .alpha(0.3f),
            contentScale = ContentScale.Crop
        )
        Logo()
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "Recomendadas",
                fontSize = 30.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontFamily = archivoBlack,

                )
            Text(
                text = "para você",
                fontSize = 30.sp,
                color = Color.White,
                fontFamily = archivoBlack,
                modifier = Modifier.offset(x = 100.dp)

            )

        }
    }
}

@Preview
@Composable
private fun RecomendadasPreview() {
    Recomendadas()
}
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.zIndex
import com.nitro.arquivomobileoficialnitro.R

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(180.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // A imagem maior posicionada no centro da Box
        Image(
            painter = painterResource(id = R.drawable.nitro125),
            contentDescription = "Nitro Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .shadow(
                    elevation = 60.dp,
                    spotColor = Color(0xFF4A83DE),
                    ambientColor = Color(0xFF4A83DE)
                )
                .size(180.dp)
        )
    }
}

@Preview
@Composable
private fun LogoPreview() {
    Logo()
}
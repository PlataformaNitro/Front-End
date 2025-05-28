import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.nitro.arquivomobileoficialnitro.R

@Composable
fun BackgroundPrincipal(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.img_background_claro_nitro),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
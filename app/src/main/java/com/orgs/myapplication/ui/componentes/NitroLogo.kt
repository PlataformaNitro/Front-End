import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.orgs.myapplication.R

@Composable
fun NitroLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.nitrologo),
        contentDescription = "Logo",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun NitroLogoPreview() {
    NitroLogo()
}
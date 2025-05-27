import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.arquivomobileoficialnitro.R

@Composable
fun LogoDark(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.nitro_logo_dark),
        contentDescription = "Logo da Nitro",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
private fun LogoDarkPreview() {
    LogoDark()
}
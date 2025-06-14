import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.orgs.myapplication.R

@Composable
fun ImagemPerfil(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.avatarplaceholder),
        contentDescription = "placeholder Avatar",
        modifier = modifier.clip(shape = CircleShape),
        contentScale = ContentScale.Crop

    )

}

@Preview
@Composable
private fun ImagemPerfilPreview() {
    ImagemPerfil()
}
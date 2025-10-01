import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.orgs.myapplication.R
val gradiente = Brush.linearGradient(
    colorStops = arrayOf(
        0.0f to Color(0xFF021030),
        0.3f to Color(0xFF021030),
        1.0f to Color(0xFF014677)
    )
)
@Composable
fun BackgroundPrincipal(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // 1. Fundo com o gradiente
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradiente)
        )
        // 2. Sobreposição preta semi-transparente
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )
    }
}

@Preview
@Composable
private fun BackgroundPrincipalPreview() {
    BackgroundPrincipal()
}
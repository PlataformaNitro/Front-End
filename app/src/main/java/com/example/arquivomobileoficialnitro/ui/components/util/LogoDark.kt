import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R

@Composable
fun LogoDark(modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        Text(
            text = "Nitro",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.archivo_black)),
            fontWeight = FontWeight.W400,
            color = Color.White
        )


    }

}

@Preview()
@Composable
private fun LogoDarkPreview() {
    LogoDark()
}
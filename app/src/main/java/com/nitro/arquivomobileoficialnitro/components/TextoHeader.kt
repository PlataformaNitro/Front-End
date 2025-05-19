import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nitro.arquivomobileoficialnitro.ui.theme.archivoBlack

@Composable
fun TextoHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(start = 10.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = "Olá, David!",
            fontSize = 36.sp,
            fontFamily = archivoBlack,
            color = Color.White
        )
        Text(
            text = "faça sua jornada!",
            fontSize = 20.sp,
            fontFamily = archivoBlack,
            color = Color.Gray
        )
    }
}

@Preview
@Composable
private fun TextoHeaderPreview() {
    TextoHeader()
}

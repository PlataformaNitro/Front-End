import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nitro.arquivomobileoficialnitro.ui.theme.archivoBlack

@Composable
fun TituloContainer(leftText:String,rightText:String) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
        Text(
            text = leftText, fontSize = 20.sp, color = Color.White, fontFamily = archivoBlack
        )
        Text(
            text = rightText, fontSize = 15.sp, color = Color.White, fontFamily = archivoBlack
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TituloContainerPreview() {
    TituloContainer("talvez você conheça","ver mais")
}
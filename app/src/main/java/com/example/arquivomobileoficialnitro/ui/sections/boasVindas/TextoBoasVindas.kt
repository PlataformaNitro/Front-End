import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import com.example.arquivomobileoficialnitro.R

// Supondo que você tenha os arquivos de fonte em res/font:
// R.font.archivo para Archivo normal 700
// R.font.archivo_black para Archivo Black 400

val archivo = FontFamily(
    Font(R.font.archivo, weight = FontWeight.Bold) // weight 700
)

val archivoBlack = FontFamily(
    Font(R.font.archivo_black) // weight 400
)


@Composable
fun TextoBoasVindas(modifier: Modifier = Modifier,color:Color,textBoasVindas:String) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Bem vindo!",
            color = color,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 17.dp),
            fontFamily = archivo,
            fontWeight = FontWeight.Bold, // 700
            fontSize = 25.sp,
            lineHeight = 25.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = textBoasVindas,
            color = Color(0xFF798797), // FF = 100% opaco
           modifier = modifier.fillMaxWidth(),
            fontFamily = archivoBlack,
            fontWeight = FontWeight.Normal, // 400
            fontSize = 15.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextoBoasVindasPreview() {
    TextoBoasVindas(color = Color.Black, textBoasVindas = "Nitro, sua ferramenta para viagens seguras e confortáveis sem qualquer tipo de preocupação")
}

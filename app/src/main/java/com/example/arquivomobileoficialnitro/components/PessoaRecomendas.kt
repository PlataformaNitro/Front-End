import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.R
import com.example.myapplication.ui.theme.archivoBlack

@Composable
fun PessoasRecomendadas(image:Int) {
    Column(Modifier.width(100.dp)) {
        FotoPerfil(100, image)
        Text("Diego", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), color = Color.White, fontFamily = archivoBlack,)
    }
}

@Preview
@Composable
private fun PessoasRecomendadasPreview() {
    PessoasRecomendadas( R.drawable.foto_perfil_amigos_recomendados)
}
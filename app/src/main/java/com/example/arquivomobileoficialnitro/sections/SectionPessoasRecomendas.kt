import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.arquivomobileoficialnitro.R

@Composable
fun SectionPessoasRecomendas(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(7.dp)){
        PessoasRecomendadas(R.drawable.foto_perfil_amigos_recomendados)
        PessoasRecomendadas(R.drawable.amigos_recomendados_1)
        PessoasRecomendadas(R.drawable.amigos_recomendados_2)
        PessoasRecomendadas(R.drawable.amigos_recomendados_3)
    }
}

@Preview
@Composable
private fun SectionPessoasRecomendasPreview() {
    SectionPessoasRecomendas()
}
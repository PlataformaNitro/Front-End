import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeaderBoasVindas(modifier: Modifier = Modifier) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
            LogoDark(Modifier.size(334.dp))
            TextoBoasVindas(color = Color.White)
        }
}

@Preview(showBackground = true, backgroundColor = 0xFFBB86FC)
@Composable
private fun HeaderBoasVindasPreview() {
    HeaderBoasVindas()
}


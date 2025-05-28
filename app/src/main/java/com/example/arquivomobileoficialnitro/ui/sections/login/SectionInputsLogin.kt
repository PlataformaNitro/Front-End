import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SectionInputsLogin(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(24.dp)) {
        CamposLogin(label = "usuario")
        CamposLogin(label = "senha")
    }
}

@Preview
@Composable
private fun InputsLoginPreview() {
    SectionInputsLogin()
}
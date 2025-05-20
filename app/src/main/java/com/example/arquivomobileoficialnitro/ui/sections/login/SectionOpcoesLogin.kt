import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.arquivomobileoficialnitro.R

@Composable
fun SectionOpcoesLogin(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.facebook), // ícone do Facebook
            contentDescription = "Login com Facebook",
            Modifier.size(51.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.google), // ícone do Google
            contentDescription = "Login com Google",
            Modifier.size(51.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.apple), // ícone da Apple
            contentDescription = "Login com Apple",
            Modifier.size(51.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SectionOpcoesLoginPreview() {
    SectionOpcoesLogin()
}

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nitro.arquivomobileoficialnitro.R

@Composable
fun SectionCardHome(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(17.dp), modifier = Modifier.fillMaxWidth()){
        CardHome(image = R.drawable.eventosacontecendo)
        CardHome(image = R.drawable.eventosacontecendo)
        CardHome(image = R.drawable.eventosacontecendo)
        CardHome(image = R.drawable.eventosacontecendo)
    }
}

@Preview
@Composable
private fun SectionCardHomePreview() {
    SectionCardHome()
}
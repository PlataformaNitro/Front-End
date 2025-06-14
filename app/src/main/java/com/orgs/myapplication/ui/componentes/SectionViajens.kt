import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Viajem

@Composable
fun SectionViajens(modifier: Modifier = Modifier, viajens: List<Viajem>, title:String) {
    Column{
        Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
            Text(title,Modifier.padding(top = 10.dp, start = 16.dp), color = Color.White, fontSize = 15.sp)
            Text("Ver Mais",Modifier.padding(top = 10.dp, end = 16.dp),Color.White)
        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),contentPadding = PaddingValues(horizontal = 16.dp)) {
            items(viajens){viajem ->
                ViajemItem(viajem = viajem)
            }
        }

    }
}
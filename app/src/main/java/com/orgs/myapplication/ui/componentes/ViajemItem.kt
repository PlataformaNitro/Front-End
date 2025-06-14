import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.R
import model.Viajem

@Composable
fun ViajemItem(modifier: Modifier = Modifier, viajem:Viajem) {
    Box(){
        Image(painter = painterResource(R.drawable.image_6_), contentDescription = viajem.origem, contentScale = ContentScale.Crop, modifier = Modifier.clip(
            RoundedCornerShape(10.dp)).size(130.dp))
        Text(viajem.destino + " -> "+ "\n" + viajem.destino, color = Color.White, modifier = Modifier.align(Alignment.BottomStart).padding(4.dp), fontSize = 15.sp, fontWeight = FontWeight.Bold)
    }
}
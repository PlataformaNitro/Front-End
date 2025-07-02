import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.Model.User
import com.example.nitroapp.ui.screens.PerfilActivity

@Composable
fun UserCard(user: User) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                val intent = Intent(context, PerfilActivity::class.java).apply {
                    putExtra("nome", user.nome)
                    putExtra("imagem", user.imagem)
                    putExtra("bio", user.bio)
                    putExtra("moto", user.moto)
                    putExtra("tipo", user.tipo)
                    putExtra("totalKm", user.totalKm)
                }
                context.startActivity(intent)
            }
            .padding(8.dp)
    ) {
        Box {
            ImagemPerfil(Modifier.size(81.dp), user = user)
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .clip(CircleShape)
                    .background(color = Color.White)
                    .size(30.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "adicionar",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Text(user.nome, color = Color.White, fontSize = 15.sp)
    }
}

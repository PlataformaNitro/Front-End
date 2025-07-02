import android.content.Intent
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.shadow
import com.orgs.myapplication.R

@Composable
fun BotaoCompartilhar() {
    val context = LocalContext.current

    IconButton(
        onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Confira essa viagem!")
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Olha só essa viagem incrível no app Nitro! 🚀🌍"
                )
            }
            context.startActivity(
                Intent.createChooser(intent, "Compartilhar via")
            )
        },
        modifier = Modifier.size(49.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.icone_compartihamento),
            contentDescription = "Compartilhar",
            modifier = Modifier
                .size(width = 38.dp, height = 41.dp)
                .shadow(40.dp),
            tint = Color.White
        )
    }
}

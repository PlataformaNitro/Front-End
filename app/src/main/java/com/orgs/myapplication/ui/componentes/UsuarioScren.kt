import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.aluvery.dao.User
import androidx.compose.ui.unit.dp

@Composable
fun UsuarioScreen(modifier: Modifier = Modifier, users: List<User>) {
    Column {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(users.chunked(2)) { userPair ->
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    userPair.forEach { user ->
                        UsuarioItem(user = user, modifier = Modifier.weight(1f))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
@Preview
@Composable
private fun UsuarioScreenPreview() {
    UsuarioScreen(users = sampleUsers)
}
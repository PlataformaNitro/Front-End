
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Text // Import duplicado, removido para usar o do material3
import androidx.compose.material3.Surface // Import corrigido para androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.tooling.preview.datasource.LoremIpsum // Import não utilizado
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.dao.User
//import br.com.alura.aluvery.extensions.toBrazilianCurrency // Import não utilizado
//import br.com.alura.aluvery.model.Product // Import não utilizado
//import br.com.alura.aluvery.ui.theme.AluveryTheme // Import não utilizado
import com.orgs.myapplication.R
import com.orgs.myapplication.ui.theme.MyApplicationTheme
//import java.math.BigDecimal // Import não utilizado

@Composable
fun UsuarioItem(
    user: User,
    modifier: Modifier = Modifier,
) {
    MyApplicationTheme {
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp // Propriedade elevation foi substituída por shadowElevation no Material3
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Blue,
                                Color.Cyan
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(user.imagem), // Propriedade paint foi substituída por painter
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter) ,
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = user.nome,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
}

@Preview(showBackground = true)
@Composable
private fun UsuarioItemPreview() { // Nome da Preview corrigido para refletir o Composable
    MyApplicationTheme {
        Surface {
            UsuarioItem(
                user = User(
                    nome = "ruan",
                    imagem = R.drawable.avatarplaceholder
                )
            )
        }
    }
}
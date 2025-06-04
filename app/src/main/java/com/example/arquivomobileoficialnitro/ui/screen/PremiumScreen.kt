import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.components.telaHome.FotoPerfil
import com.example.arquivomobileoficialnitro.ui.components.telaHome.TextoHeader
import com.example.arquivomobileoficialnitro.ui.components.util.BackgroundSecundario

@Composable
fun PremiumScreen(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize()){
        BackgroundSecundario()
        Column(Modifier.padding(horizontal = 16.dp, vertical = 5.dp).fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Nitro", fontSize = 23.sp, color = Color.White, fontWeight = FontWeight.Bold,modifier = Modifier.fillMaxWidth())
            Row(Modifier.fillMaxWidth()) {
                FotoPerfil(74, R.drawable.foto_perfil, modifier.size(57.dp))
                TextoHeader(tamanhoFontTitulo = 30, tamanhoFontDescricao = 15)
            }
            Image(painter = painterResource(id = R.drawable.icbike), contentDescription = null,
                Modifier.height(200.dp))
            FeaturesSection()
            PricingOptions()
            Spacer(Modifier.height(13.dp))
            BotaoDeEntrada(
                texto = "cadastrar",
                containerColor = Color(red = 0x5D, green = 0x7F, blue = 0xA5, alpha = 0xB2),
                onClick = {
                }
            )
        }
    }
}

@Composable
fun FeaturesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                FeatureItem("★ Pontos Limitados")
                FeatureItem("★ Clima em tempo real")
                FeatureItem("❌ Alerta de Manutenção", Color.Red)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                FeatureItem("★ Sugestão de rotas")
                FeatureItem("★ Planejamento ilimitado")
                FeatureItem("❌ Publicidade de motoclube", Color.Red)
            }
        }
    }
}

@Composable
fun FeatureItem(text: String, color: Color = Color.White) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        color = color,
        fontSize = 20.sp,
        modifier = Modifier.padding(vertical = 6.dp),
    )
}

@Composable
fun PricingOptions() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PricingCard("Nitro Basic", "4 funcionalidades", "Free", background = Color(0xFF284469))
        PricingCard("Nitro Sport", "5 funcionalidades", "R$ 40,00")
        PricingCard("Nitro Turbo", "App completo", "R$ 80,00")
    }
}

@Composable
fun PricingCard(
    title: String,
    subtitle: String,
    price: String,
    background: Color = Color(0xFFE5E5E5)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(background, RoundedCornerShape(16.dp))
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            Text(subtitle, fontSize = 14.sp, color = Color.DarkGray)
        }
        Text(price, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
    }
}


@Preview
@Composable
private fun PremiumScreenPreview() {
    PremiumScreen()
}
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomMenu(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(292.dp)
            .height(70.dp), // altura um pouco maior pra acomodar a curva
        contentAlignment = Alignment.Center
    ) {
        // Fundo arredondado
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF1A1A1A))
        )

        // Ícones e textos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MenuButton(icon = Icons.Filled.Home, label = "Home", onClick = {})
            MenuButton(icon = Icons.Filled.Warning, label = "SOS", onClick = {})
            MenuButton(icon = Icons.Filled.Map, label = "Mapa", onClick = {}, labelOverride = "GO")
        }
    }
}

@Composable
fun MenuButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    labelOverride: String? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color.White,
            modifier = Modifier.size(36.dp)
        )
        Text(
            text = labelOverride ?: label,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000, widthDp = 400, heightDp = 120)
@Composable
fun BottomMenuPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        BottomMenu()
    }
}

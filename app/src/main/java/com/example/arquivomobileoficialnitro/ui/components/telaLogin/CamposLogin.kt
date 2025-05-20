import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CamposLogin(modifier: Modifier = Modifier, label:String) {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = label,
                fontWeight = FontWeight.W400,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
                color = Color.Black.copy(alpha = 0.6f)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFB8CAD4),
            unfocusedContainerColor = Color(0xFFB8CAD4),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Black.copy(alpha = 0.6f),
            unfocusedLabelColor = Color.Black.copy(alpha = 0.6f),
        ),
        modifier = modifier
            .width(340.dp)
            .height(59.dp),
        shape = RoundedCornerShape(20.dp)
    )
}

@Preview(showBackground = true,backgroundColor = 0xFFBB86FC)
@Composable
private fun CamposLoginPreview() {
    CamposLogin(label = "usuario")
}
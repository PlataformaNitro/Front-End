import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchText(text:String, state: EventoScreenUiState) {
    OutlinedTextField(
        textStyle = TextStyle(color = Color(0xFF9CA7B8), fontWeight = FontWeight.Bold,fontSize = 20.sp),
        value = text,
        onValueChange = state.onSearchChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
        ,
        shape = RoundedCornerShape(20.dp),
        placeholder = { Text("Nome do evento",color = Color(0xFF9CA7B8), fontWeight = FontWeight.Bold,fontSize = 20.sp)},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White
                )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFF1C2228),
            focusedContainerColor = Color(0xFF1C2228),
        )
    )
}

@Preview
@Composable
private fun SearchTextPreview() {
    SearchText(text = "nomd", state = EventoScreenUiState())
}
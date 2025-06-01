import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.ui.components.util.BackgroundSecundario
import kotlinx.coroutines.delay



@Composable
fun VerificarCodigoScreen(navController: NavController?=null) {
    val codigo = remember { mutableStateListOf("", "", "", "", "", "") }
    var tempo by remember { mutableStateOf(60) }
    val scrollState = rememberScrollState()

    // Inicia contagem regressiva
    LaunchedEffect(Unit) {
        while (tempo > 0) {
            delay(1000)
            tempo--
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BackgroundSecundario()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(scrollState)
        ) {
            LogoDark(Modifier.size(200.dp))
            // Imagem ilustrativa
            Image(
                painter = painterResource(id = android.R.drawable.ic_dialog_email), // Substitua por seu ícone personalizado
                contentDescription = "Ícone Email",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Verificar código",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Digite o código recebido em",
                fontSize = 14.sp,
                color = Color.LightGray
            )
            Text(
                text = "yourmail@example.com",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (i in 0..5) {
                    OutlinedTextField(
                        value = codigo[i],
                        onValueChange = {
                            if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                                codigo[i] = it
                            }
                        },
                        modifier = Modifier
                            .width(45.dp)
                            .height(55.dp),
                        textStyle = LocalTextStyle.current.copy(
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray,
                            textColor = Color.White
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        visualTransformation = VisualTransformation.None
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Reenviar código em 0:${tempo.toString().padStart(2, '0')}",
                fontSize = 14.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* lógica de verificação */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E4D91)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Verificar", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerificarCodigoScreenPreview() {
    VerificarCodigoScreen()
}

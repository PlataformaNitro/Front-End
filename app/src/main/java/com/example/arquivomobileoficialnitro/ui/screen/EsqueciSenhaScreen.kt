import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.R

@Composable
fun EsqueciSenhaScreen(navController: NavController?=null) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001B3D)) // Fundo azul escuro
            .padding(24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {

            // Logo (você pode trocar por Image(painter = ..., contentDescription = ...) se tiver o recurso)
           LogoDark(Modifier.size(200.dp))
            

            // Ícone de Cadeado (use seu recurso real se tiver)
            Image(
                painter = painterResource(id = R.drawable.seguranca), // Substitua por seu drawable personalizado
                contentDescription = "Reset Icon",
                modifier = Modifier
                    .size(290.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Esqueci a senha",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Insira um Email associado à sua conta para receber as instruções de troca de senha.",
                fontSize = 14.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Insira um Email *", color = Color.LightGray) },
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = null, tint = Color.LightGray)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Clique aqui caso não tenha recebido.",
                fontSize = 14.sp,
                color = Color(0xFF339CFF),
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { /* ação opcional */ }
                    .padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* lógica de resetar senha */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1E4D91)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Resetar senha",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.clickable {
                        navController?.navigate("verificarCodigo") {
                            popUpTo("splash") { inclusive = true }
                        }
                    }
                )

            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Voltar ao Login",
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable { navController?.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    } }
                    .padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EsqueciSenhaScreenPreview() {
    EsqueciSenhaScreen()
}

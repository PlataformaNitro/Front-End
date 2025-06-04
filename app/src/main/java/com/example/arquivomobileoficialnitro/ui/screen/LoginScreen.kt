import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.R
import com.example.arquivomobileoficialnitro.ui.components.util.BackgroundSecundario

@Composable
fun NitroLoginScreen(navController: NavController?=null) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.register_2_background),
            contentDescription = "uma tela com fundo azul icones de montanha em baixo e a logo nitro em cima",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                .padding(16.dp)
        )
        {
            Spacer(modifier = Modifier.height(234.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Usuário ou Email", color = Color.LightGray) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo senha
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Senha", color = Color.LightGray) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Alternar visibilidade"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Checkbox e Esqueci a senha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
                    )
                    Text("Lembrar-me", color = Color.White)
                }
                Text("Esqueci a senha", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.clickable {
                    navController?.navigate("esqueciSenha") {
                        popUpTo("splash") { inclusive = true }
                    }
                })
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Entrar
           BotaoDeEntrada("Entrar",Color(0xB2111F21), onClick = {
               navController?.navigate("homePage") {
                   popUpTo("splash") { inclusive = true }
               }})

            Spacer(modifier = Modifier.height(24.dp))

            // Ícones sociais (suponha que tenha ícones personalizados em drawable)
            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier.size(40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.size(40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.twiter),
                    contentDescription = "X",
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth() // necessário para ocupar largura total
            )

            Text(
                buildAnnotatedString {
                    append("Não possui conta? ")
                    withStyle(style = SpanStyle(color = Color.Cyan, fontWeight = FontWeight.Bold)) {
                        append("Cadastrar")
                    }
                },
                modifier = Modifier.padding(bottom = 8.dp).clickable{
                    navController?.navigate("cadastro") {
                        popUpTo("splash") { inclusive = true }
                    }
                },
                color = Color.White
            )
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview
@androidx.compose.runtime.Composable
private fun NitroLoginScreenPreview() {
    NitroLoginScreen()
}
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.R

@Composable
fun RegisterScreen(navController: NavController?=null) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var nascimento by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var repetirSenha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    var repetirSenhaVisivel by remember { mutableStateOf(false) }
    var concordaTermos by remember { mutableStateOf(false) }
    var receberNovidades by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val backgroundColor = Color(0xFF00112A)

    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.register_2_background),
            contentDescription = "uma tela com fundo azul icones de montanha em baixo e a logo nitro em cima",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState) // Permite rolagem
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(130.dp))
            // Logo substituto (você pode trocar por uma imagem real do drawable)
            Text(
                "Criar uma conta",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White
            )
            Text("Registre-se para continuar", fontSize = 14.sp, color = Color.LightGray)

            Spacer(Modifier.height(24.dp))

            InputField("Nome Completo", nome) { nome = it }
            InputField("E-mail", email, keyboardType = KeyboardType.Email) { email = it }
            InputField("Telefone", telefone, keyboardType = KeyboardType.Phone) { telefone = it }
            InputField("Nascimento:", nascimento) { nascimento = it }

            PasswordField(
                label = "Senha",
                value = senha,
                visible = senhaVisivel,
                onValueChange = { senha = it },
                onVisibilityChange = { senhaVisivel = !senhaVisivel }
            )

            PasswordField(
                label = "Repita a senha",
                value = repetirSenha,
                visible = repetirSenhaVisivel,
                onValueChange = { repetirSenha = it },
                onVisibilityChange = { repetirSenhaVisivel = !repetirSenhaVisivel }
            )


            Spacer(Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = concordaTermos, onCheckedChange = { concordaTermos = it })
                Text("Concordo com os ", color = Color.White)
                Text(
                    text = "Termos De Uso",
                    color = Color(0xFF448AFF),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* ação */ }
                )
                Text(".", color = Color.White)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = receberNovidades, onCheckedChange = { receberNovidades = it })
                Text(
                    "Desejo receber novidades promocionais.",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }

            Spacer(Modifier.height(16.dp))
            BotaoDeEntrada(
                texto = "cadastrar", Color(red = 0x5D, green = 0x7F, blue = 0xA5, alpha = 0xB2),
                onClick = {
                    navController?.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
            Spacer(Modifier.height(16.dp))
            Text(
                buildAnnotatedString {
                    append("Já possui uma conta? ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF448AFF),
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Entrar")
                    }
                },
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier.clickable {
                    navController?.navigate("login") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.LightGray) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.Gray,
            textColor = Color.White
        )
    )
}

@Composable
fun PasswordField(
    label: String,
    value: String,
    visible: Boolean,
    onValueChange: (String) -> Unit,
    onVisibilityChange: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.LightGray) },
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onVisibilityChange) {
                Icon(
                    imageVector = if (visible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = null,
                    tint = Color.LightGray
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.Gray,
            textColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}

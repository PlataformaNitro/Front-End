import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orgs.myapplication.Model.Evento

class FormularioScreenUiState
    (val texto: String = "",
     val descricao: String = "",
     val onTextChange: (String) -> Unit = {},
     val onDescricaoChange: (String) -> Unit = {}
    )

@Composable
fun FormularioScreen(onSalveClick: (Evento) -> Unit = {}) {
    var texto by rememberSaveable { mutableStateOf("") }
    var descricao by rememberSaveable { mutableStateOf("") }
    val state = FormularioScreenUiState(texto = texto, onTextChange = { texto = it}, descricao = descricao, onDescricaoChange = {descricao = it})
    val onSaveClick = {
        if (texto.isNotBlank() && descricao.isNotBlank()) {
            val eventoObject = Evento(texto, descricao)
            onSalveClick(eventoObject)
        }else{
            var mostrarError:Boolean = true
        }
    }
    FormularioScreen(state = state, onSaveClick = onSaveClick)
}


@Composable
fun FormularioScreen(modifier: Modifier = Modifier,state: FormularioScreenUiState = FormularioScreenUiState(), onSaveClick:() -> Unit = {}) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        TextField(
            value = state.texto,
            onValueChange = state.onTextChange,
            modifier = modifier.padding(vertical = 32.dp, horizontal = 16.dp),
            label = { Text("Nome do evento") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),

            )
        TextField(
            value = state.descricao,
            onValueChange = state.onDescricaoChange,
            modifier = modifier.padding(vertical = 32.dp, horizontal = 16.dp),
            label = { Text("descrição do evento") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),

            )
        Button(modifier = modifier.padding(horizontal = 16.dp), onClick = onSaveClick
        ) { Text("Salvar") }
    }
}

@Preview
@Composable
private fun FormularioScreenPreview() {
    FormularioScreen()
}
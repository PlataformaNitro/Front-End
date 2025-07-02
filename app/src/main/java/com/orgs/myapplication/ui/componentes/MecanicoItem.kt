import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.orgs.myapplication.Model.Mecanico
import com.orgs.myapplication.R

@Composable
fun MecanicoItem(
    modifier: Modifier = Modifier,
    mecanico: Mecanico,
    larguraTexto: Dp = 130.dp
) {
    var mostrarDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
            .background(Color(0xFF162A45))
            .padding(vertical = 14.dp, horizontal = 5.dp)
            .width(243.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { mostrarDialog = true }
    ) {
        Row {
            Image(
                painter = painterResource(mecanico.imagem),
                contentDescription = "Imagem do mecânico",
                modifier = Modifier
                    .height(180.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .width(larguraTexto)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = mecanico.nome,
                    modifier = Modifier.padding(top = 10.dp, start = 8.dp),
                    color = Color.White,
                    fontSize = 16.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = mecanico.descricao,
                    modifier = Modifier.padding(top = 11.dp, start = 8.dp),
                    color = Color.LightGray,
                    fontSize = 13.sp,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    if (mostrarDialog) {
        Dialog(onDismissRequest = { mostrarDialog = false }) {
            var favorito by remember { mutableStateOf(false) }
            var fontSizeSmall by remember { mutableStateOf(14.sp) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
                    .background(Color(0xFF162A45), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column( modifier = Modifier
                    .verticalScroll(rememberScrollState())) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { favorito = !favorito }) {
                            Icon(
                                painter = painterResource(
                                    if (favorito) R.drawable.icone_estrela_ativada else R.drawable.icone_estrela_desativada
                                ),
                                contentDescription = "Favoritar",
                                tint = if (favorito) Color.Red else Color.LightGray
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(onClick = {
                            fontSizeSmall = if (fontSizeSmall == 14.sp) 18.sp else 14.sp
                        }) {
                            Text(text = if (fontSizeSmall == 14.sp) "A+" else "A-")
                        }
                    }

                    Image(
                        painter = painterResource(mecanico.imagem),
                        contentDescription = "Imagem ampliada",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = mecanico.nome,
                        color = Color.White,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = mecanico.descricao,
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "📍 Local: ${mecanico.local}",
                        color = Color.Gray,
                        fontSize = fontSizeSmall
                    )

                    Text(
                        text = "📞 Contato: ${mecanico.contato}",
                        color = Color.Gray,
                        fontSize = fontSizeSmall
                    )

                    Text(
                        text = "⏰ Horário: ${mecanico.horario}",
                        color = Color.Gray,
                        fontSize = fontSizeSmall
                    )

                    Text(
                        text = "🛠️ Especialidades: ${mecanico.especialidades.joinToString(", ")}",
                        color = Color.Gray,
                        fontSize = fontSizeSmall
                    )

                    Text(
                        text = "⭐ Avaliação: ${mecanico.avaliacao}",
                        color = Color.Gray,
                        fontSize = fontSizeSmall
                    )

                    Text(
                        text = "📆 Experiência: ${mecanico.experiencia} anos",
                        color = Color.Gray,
                        fontSize = fontSizeSmall
                    )

                    if (mecanico.destaque.isNotEmpty()) {
                        Text(
                            text = "🏅 Destaques: ${mecanico.destaque.joinToString(", ")}",
                            color = Color.Gray,
                            fontSize = fontSizeSmall
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { mostrarDialog = false },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Fechar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MecanicoItemPreview() {
    val mecanico = Mecanico(
        imagem = R.drawable.moto_tool_1,
        nome = "Carlos da Oficina Rápida",
        descricao = "Especialista em diagnósticos rápidos e manutenção preventiva.",
        especialidades = listOf("Troca de óleo", "Freios", "Injeção eletrônica"),
        avaliacao = 4.7,
        contato = "(11) 99876-1234",
        horario = "Seg a Sab: 08h às 18h",
        experiencia = 15,
        destaque = listOf("Atendimento rápido", "Peças originais"),
        local = "São Paulo - SP"
    )
    MecanicoItem(mecanico = mecanico)
}

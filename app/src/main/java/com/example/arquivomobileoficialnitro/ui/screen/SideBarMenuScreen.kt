package com.example.nitroapp.ui.components

import LogoDark
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.arquivomobileoficialnitro.ui.sections.homeimport.Header
import com.example.arquivomobileoficialnitro.R

data class MenuItem(val title: String, val icon: ImageVector)


@Composable
fun SideDrawerMenu(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier)
{
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Brush.verticalGradient(listOf(Color(0xFF001233), Color(0xFF003366))))
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Botão de fechar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { onItemClick("close") }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Fechar Menu",
                    tint = Color.White
                )
            }
        }

        // Header
        Header()

        Spacer(modifier = Modifier.height(24.dp))

        // Nitro Pro card
        Card(
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color(0xFF375A8C),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onItemClick("Seja Nitro Pro") }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icbike),
                    contentDescription = "Icone de moto",
                    modifier = Modifier.size(90.dp)
                )
                Text("Seja Nitro Pro", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Menu items
        val menuItems = listOf(
            MenuItem("Inicio", Icons.Filled.Home),
            MenuItem("Perfil", Icons.Filled.Person),
            MenuItem("Configuração", Icons.Filled.Settings),
            MenuItem("Moto Clube", Icons.Filled.DirectionsBike),
            MenuItem("Rotas Salvas", Icons.Filled.Place),
            MenuItem("Ajuda", Icons.Filled.Help),
            MenuItem("Sair", Icons.Filled.ExitToApp)
        )

        menuItems.forEach { item ->
            DrawerMenuItem(item = item) { onItemClick(it) }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun DrawerMenuItem(item: MenuItem, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { onClick(item.title) }
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.title,
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(item.title, color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF001233)
@Composable
fun SideDrawerMenuPreview() {
    SideDrawerMenu(onItemClick = {})
}

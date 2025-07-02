package com.example.nitroapp.ui.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nitroapp.ui.screens.PerfilActivity
import com.orgs.myapplication.R
import com.orgs.myapplication.ui.Activitys.ConfiguracoesActivity


data class MenuItem(val title: String, val icon: ImageVector)

@Composable
fun SideDrawerMenu(
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF001233), Color(0xFF003366))
                )
            )
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Botão fechar menu
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

        Spacer(modifier = Modifier.height(24.dp))

        // Menu items
        val menuItems = listOf(
            MenuItem("Perfil", Icons.Filled.Person),
            MenuItem("Configuração", Icons.Filled.Settings),
            MenuItem("Favoritos", Icons.Filled.Star),
            MenuItem("Rotas Salvas", Icons.Filled.Place),
            MenuItem("Ajuda", Icons.Filled.Info),
            MenuItem("Sair", Icons.Filled.ExitToApp)
        )

        menuItems.forEach { item ->
            DrawerMenuItem(item = item) { title ->
                when (title) {
                    "Perfil" -> {
                        context.startActivity(Intent(context, PerfilActivity::class.java))
                    }
                    "Configuração" -> {
                        context.startActivity(Intent(context, ConfiguracoesActivity::class.java))
                    }
                    else -> onItemClick(title)
                }
            }
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
        Text(
            text = item.title,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF001233)
@Composable
fun SideDrawerMenuPreview() {
    SideDrawerMenu(onItemClick = {})
}

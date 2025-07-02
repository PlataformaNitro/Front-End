package com.example.nitroapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext

@Composable
fun ConfiguracoesScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(
            text = "Configurações",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SettingsSection(title = "Perfil") {
            SettingsItem(icon = Icons.Default.Person, text = "Editar Perfil") { /* Navegar para editar */ }
            SettingsItem(icon = Icons.Default.Email, text = "Alterar E-mail") { /* Navegar */ }
            SettingsItem(icon = Icons.Default.Lock, text = "Alterar Senha") { /* Navegar */ }
        }

        SettingsSection(title = "Preferências") {
            SettingsItem(icon = Icons.Default.ThumbUp, text = "Tema") { /* Alternar tema */ }
            SettingsItem(icon = Icons.Default.Lock, text = "Idioma") { /* Abrir opções de idioma */ }
            SettingsItem(icon = Icons.Default.Notifications, text = "Notificações") { /* Ajustes de notificação */ }
        }

        SettingsSection(title = "Privacidade") {
            SettingsItem(icon = Icons.Default.Face, text = "Visibilidade do Perfil") { /* Abrir opções */ }
            SettingsItem(icon = Icons.Default.Face, text = "Usuários Bloqueados") { /* Navegar */ }
            SettingsItem(icon = Icons.Default.LocationOn, text = "Compartilhar Localização") { /* Ativar/Desativar */ }
        }

        SettingsSection(title = "Conta") {
            SettingsItem(icon = Icons.Default.ExitToApp, text = "Sair da Conta") { /* Logout */ }
            SettingsItem(icon = Icons.Default.Delete, text = "Excluir Conta") { /* Abrir confirmação */ }
        }

        SettingsSection(title = "Ajuda") {
            SettingsItem(icon = Icons.Default.Info, text = "Sobre o App") { /* Versão, etc */ }
            SettingsItem(icon = Icons.Default.Warning, text = "Suporte") { /* Navegar */ }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SettingsSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        content()
        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun SettingsItem(icon: ImageVector, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, style = MaterialTheme.typography.bodyLarge)
    }
}

package com.example.nitroapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.R

@Composable
fun PerfilScreen() {
    var nome by remember { mutableStateOf("Ruan Duarte") }
    var email by remember { mutableStateOf("ruan@exemplo.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto de perfil
        Image(
            painter = painterResource(id = R.drawable.motinha), // Substitua por uma imagem de perfil real
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nome
        Text(text = nome, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        // Email
        Text(text = email, fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(24.dp))

        // Botão de edição
        Button(
            onClick = {
                // Aqui você pode abrir um dialog ou navegar para uma tela de edição
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF375A8C))
        ) {
            Icon(Icons.Default.Edit, contentDescription = "Editar", tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Editar Perfil", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview() {
    PerfilScreen()
}

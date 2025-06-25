package com.orgs.myapplication.ui.Screen

import ImagemPerfil
import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orgs.myapplication.Dao.User
import com.orgs.myapplication.R
import kotlin.arrayOf


@Preview (showBackground = true)
@Composable
fun Menu () {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFF021030),
                        0.7f to Color(0xFF021030),
                        1.0f to Color(0xFF014677)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Boa tarde,",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 15.dp, top = 35.dp)
                )
                Text(
                    "Diego!",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
            ImagemPerfil(
                modifier = Modifier
                    .padding(end = 20.dp, top = 25.dp)
                    .size(75.dp),
                user = User("Diego", R.drawable.avatar_1)
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(
            onClick = { /*PlansScreen*/ },
            modifier = Modifier
                .width(265.dp)
                .height(140.dp)
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(20.dp)
                ),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF014677),
                contentColor = Color.White
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.motinha),
                contentDescription = "Icon de Moto",
                modifier = Modifier
                    .size(100.dp)
            )
            Text(
                text = "Seja Nitro Pro",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Ícone de Home",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Início",
                    fontSize = 28.sp
                )

            }

            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Ícone de Perfil",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Perfil",
                    fontSize = 28.sp
                )

            }

            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Ícone de Configuracões",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Configurações",
                    fontSize = 28.sp
                )
            }
            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Ícone de Moto",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Moto Clube",
                    fontSize = 28.sp
                )
            }
            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Ícone de Estrela",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Rotas Salvas",
                    fontSize = 28.sp
                )
            }

            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Warning,
                    contentDescription = "Ícone de ajuda",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Ajuda",
                    fontSize = 28.sp
                )
            }
            Button(
                onClick = { /* Ação futura */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Ícone de Mensagens",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(32.dp)
                )
                Text(
                    text = "Mensagens",
                    fontSize = 28.sp
                )
            }
            Spacer(modifier = Modifier.weight(20f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nitrologo),
                    contentDescription = "Imagem Centralizada",
                    modifier = Modifier
                        .size(500.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}



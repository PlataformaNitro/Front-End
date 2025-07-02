package com.example.nitroapp.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.arquivomobileoficialnitro.ui.screen.TelaDePerfil
import com.orgs.myapplication.Model.User
import com.orgs.myapplication.R

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = User(
            nome = intent.getStringExtra("nome") ?: "convidado",
            imagem = intent.getIntExtra("imagem", R.drawable.avatarplaceholder),
            bio = intent.getStringExtra("bio") ?: "amante das duas rodas",
            moto = intent.getStringExtra("moto") ?: "",
            tipo = intent.getStringExtra("tipo") ?: "",
            totalKm = intent.getIntExtra("totalKm", 0)
        )

        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                TelaDePerfil(user = user)
            }
        }
    }
}

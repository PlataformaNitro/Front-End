package com.orgs.myapplication.ui.Activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.arquivomobileoficialnitro.ui.screen.TeladeRedirecionamento
import model.Viajem

class RedirecionamentoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recebendo dados da Intent
        val viajem = Viajem(
            imagem = intent.getIntExtra("imagem", 0),
            origem = intent.getStringExtra("origem") ?: "",
            destino = intent.getStringExtra("destino") ?: "",
            descricao = intent.getStringExtra("descricao") ?: ""
        )

        setContent {
            TeladeRedirecionamento(viajem = viajem)
        }
    }
}

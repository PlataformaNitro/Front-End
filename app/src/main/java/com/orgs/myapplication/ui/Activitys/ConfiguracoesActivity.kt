package com.orgs.myapplication.ui.Activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.nitroapp.ui.screens.ConfiguracoesScreen

class ConfiguracoesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConfiguracoesScreen()
                }

        }
    }
}

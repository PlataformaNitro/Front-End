package com.orgs.myapplication.ui.Activitys

import EventDao
import EventoScreen
import EventoScreenUiState
import EventosScreenViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.orgs.myapplication.ui.theme.MyApplicationTheme
import sampleSection

class MainActivity : ComponentActivity() {
    private val dao = EventDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                App(onFabClick = {
                    startActivity(
                        Intent(
                            this,
                            FormularioEventoActivity::class.java
                        )
                    )
                }, Content = {
                    val eventos = dao.eventos()
                    val viewModel by viewModels<EventosScreenViewModel>()
                    EventoScreen(viewModel = viewModel,eventos = eventos)
                }
                )
            }
        }
    }

    @Preview
    @Composable
    private fun AppPreview() {
        App {
            EventoScreen(state = EventoScreenUiState(sections = sampleSection))
        }
    }

    @Composable
    fun App(onFabClick: () -> Unit = {}, Content: @Composable () -> Unit = {}) {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    Content()
                }
            }
        }
    }
}



package com.orgs.myapplication.ui.Activitys

import EventDao
import EventoScreen
import EventoScreenUiState
import EventosScreenViewModel
import HomeScreen
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
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.arquivomobileoficialnitro.ui.screen.ScreenMaps
import com.orgs.myapplication.ui.theme.MyApplicationTheme
import sampleSection

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                App(onFabClick = {
                    startActivity(
                        Intent(
                            this,
                            MapActivity::class.java
                        )
                    )
                }, Content = {
                    val viewModel by viewModels<EventosScreenViewModel>()
                    HomeScreen(viewModel = viewModel)
                }
                )
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App {
        HomeScreen(state = EventoScreenUiState(sections = sampleSection))
    }
}

@Composable
fun App(onFabClick: () -> Unit = {}, Content: @Composable (Modifier) -> Unit = {}) {
    Surface {
        Scaffold(floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = null
                )
            }
        }) { paddingValues ->
            Box() {
                Content( Modifier.padding(paddingValues))
            }
        }
    }
}




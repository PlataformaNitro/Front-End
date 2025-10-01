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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.orgs.myapplication.ui.Screen.MainScreen
import com.orgs.myapplication.ui.Screen.navNitro
import com.orgs.myapplication.ui.theme.MyApplicationTheme
import sampleSection
import kotlin.jvm.java

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

                NavHost(navController = navController, startDestination = navNitro.Home.name, modifier = Modifier){
                    composable(route = navNitro.Home.name) {
                        HomeScreen(onVerMaisClick = {navController.navigate(navNitro.Vermais.name) })
                    }
                    composable(route = navNitro.Vermais.name){
                        MainScreen()
                    }


            }
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
fun App(
    onFabClickMap: () -> Unit = {},
    onFabClickWarning: () -> Unit = {},
    Content: @Composable (Modifier) -> Unit = {},
) {
    Surface {
        Scaffold(floatingActionButton = {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                FloatingActionButton(onClick = onFabClickMap, containerColor = Color.Red) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }
                FloatingActionButton(onClick = onFabClickWarning) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = null
                    )
                }
            }
        }) { paddingValues ->
            Box() {
                Content(Modifier.padding(paddingValues))
            }
        }
    }
}






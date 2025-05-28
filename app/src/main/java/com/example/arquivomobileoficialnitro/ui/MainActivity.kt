package com.example.arquivomobileoficialnitro.ui

import LoginScreenController
import SplashScreenController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "splash",
                        modifier = Modifier.Companion.padding(innerPadding)
                    ) {
                        composable("splash") {
                            SplashScreenController(navController = navController)
                        }
                        composable("login") {
                            LoginScreenController(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
package com.example.arquivomobileoficialnitro.ui

import BoasVindasScreen
import EsqueciSenhaScreen
import NitroHomeScreen
import NitroLoginScreen
import RegisterScreen
import VerificarCodigoScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arquivomobileoficialnitro.ui.components.util.SplashScreen

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
                            SplashScreen(navController = navController)
                        }
                        composable("boasVindas") {
                            BoasVindasScreen(navController = navController)
                        }
                        composable ("cadastro"){
                                RegisterScreen(navController = navController)
                        }
                        composable("esqueciSenha"){
                            EsqueciSenhaScreen(navController = navController)
                        }
                        composable("verificarCodigo"){
                            VerificarCodigoScreen(navController = navController)
                        }
                        composable("login") {
                            NitroLoginScreen(navController = navController)
                        }
                        composable ("homePage"){
                            NitroHomeScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
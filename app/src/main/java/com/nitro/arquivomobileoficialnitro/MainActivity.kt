package com.nitro.arquivomobileoficialnitro

import android.os.Bundle
import androidx.compose.material3.Scaffold
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nitro.arquivomobileoficialnitro.screens.LoginScreen
import com.nitro.arquivomobileoficialnitro.ui.theme.ArquivoMobileOficialNitroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArquivoMobileOficialNitroTheme {
                Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        content = { innerPadding ->
                            LoginScreen(
                                   paddingValues = innerPadding
                            )
                        }
                    )
                }
            }
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArquivoMobileOficialNitroTheme {
        Greeting("Android")
    }
}
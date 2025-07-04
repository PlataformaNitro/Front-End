import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen() {
    val viewModel: WeatherViewModel = viewModel()
    val state by viewModel.weatherState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val currentState = state) {
            is WeatherState.Loading -> {
                Text("Carregando...")
                // Chama a API quando o composable é exibido
                viewModel.fetchWeather()
            }
            is WeatherState.Success -> {
                val weather = currentState.data
                val tempCelsius = weather.main.temp
                val tempFahrenheit = (tempCelsius * 9/5) + 32

                Text(
                    text = weather.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "${tempCelsius.toInt()} °C / ${tempFahrenheit.toInt()} °F",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            is WeatherState.Error -> {
                Text("Erro: ${currentState.message}")
            }

            else -> {}
        }
    }
}

@Preview
@Composable
private fun WeatherScreenPreview() {
    WeatherScreen()
}
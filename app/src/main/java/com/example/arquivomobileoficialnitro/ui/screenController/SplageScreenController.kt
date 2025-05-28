import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.arquivomobileoficialnitro.ui.components.util.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreenController(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    SplashScreen()
}

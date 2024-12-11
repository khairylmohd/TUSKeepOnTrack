package tus.ie.mad2.tuskeepontrack.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tus.ie.mad2.tuskeepontrack.dashboard.DashboardScreen
import tus.ie.mad2.tuskeepontrack.login.LoginScreen
import tus.ie.mad2.tuskeepontrack.login.LoginViewModel
import tus.ie.mad2.tuskeepontrack.study_mode.StartScreen
import tus.ie.mad2.tuskeepontrack.study_mode.StartScreenViewModel
import tus.ie.mad2.tuskeepontrack.study_mode.StudyScreen

@Composable
fun BuildNavigationGraph() {
    val navController = rememberNavController()
    val startScreenViewModel: StartScreenViewModel = viewModel()
    val loginViewModel : LoginViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { LoginScreen(navController = navController, viewModel = loginViewModel) }
        composable(Screen.StudyModeLocation.route) { StartScreen(navController = navController, viewModel = startScreenViewModel) }
        composable(Screen.StudyModeStart.route) { StudyScreen(navController = navController) }
        composable(Screen.Dashboard.route) { DashboardScreen(navController = navController) }
    }
}

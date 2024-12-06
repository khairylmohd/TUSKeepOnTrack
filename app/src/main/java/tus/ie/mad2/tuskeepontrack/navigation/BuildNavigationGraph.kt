package tus.ie.mad2.tuskeepontrack.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tus.ie.mad2.tuskeepontrack.study_mode.StartScreen
import tus.ie.mad2.tuskeepontrack.study_mode.StartScreenViewModel
import tus.ie.mad2.tuskeepontrack.study_mode.StudyScreen

@Composable
fun BuildNavigationGraph() {
    val navController = rememberNavController()
    val startScreenViewModel: StartScreenViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.StudyModeLocation.route) { StartScreen(navController = navController, viewModel = startScreenViewModel) }
        composable(Screen.StudyModeStart.route) { StudyScreen(navController = navController) }
    }
}

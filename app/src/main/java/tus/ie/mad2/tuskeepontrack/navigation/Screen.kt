package tus.ie.mad2.tuskeepontrack.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("Login")
    data object Dashboard : Screen("Dashboard")
    data object StudyModeLocation : Screen("StudyModeLocation")
    data object StudyModeStart : Screen("StudyModeStart")
}

package tus.ie.mad2.tuskeepontrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tus.ie.mad2.tuskeepontrack.dashboard.DashboardScreen
import tus.ie.mad2.tuskeepontrack.login.LoginScreen
import tus.ie.mad2.tuskeepontrack.moodle_events.EventScreen
import tus.ie.mad2.tuskeepontrack.navigation.BuildNavigationGraph
import tus.ie.mad2.tuskeepontrack.study_mode.StartScreen
import tus.ie.mad2.tuskeepontrack.study_mode.StudyScreen
import tus.ie.mad2.tuskeepontrack.ui.theme.TUSKeepOnTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TUSKeepOnTrackTheme {
                BuildNavigationGraph()
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
    TUSKeepOnTrackTheme {
        Greeting("Android")
    }
}
package tus.ie.mad2.tuskeepontrack.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFCAA472))
                .padding(top = 50.dp, bottom = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Dashboard",
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DashboardItem(
                    icon = Icons.Filled.Event,
                    label = "Moodle Events",
                    onClick = { /* TODO */ }
                )

                DashboardItem(
                    icon = Icons.Filled.Timer,
                    label = "Study Mode",
                    onClick = { /* TODO */  }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DashboardItem(
                    icon = Icons.Filled.BarChart,
                    label = "View Sessions",
                    onClick = { /* TODO */  }
                )

                DashboardItem(
                    icon = Icons.Filled.ExitToApp,
                    label = "Sign Out",
                    onClick = { /* TODO */ }
                )
            }
        }
    }
}

@Composable
fun DashboardItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color(0xFFFFFFFF), RectangleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(0xFFCAA472),
                modifier = Modifier.size(130.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

package tus.ie.mad2.tuskeepontrack.study_mode

import android.Manifest
import android.location.Geocoder
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*

@Composable
fun StartScreen(navController: NavHostController,
                viewModel: StartScreenViewModel
) {

    // Followed this tutorial for place picker code: https://www.youtube.com/watch?v=Z5hONYWa0b4

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var selectedLocation by remember { mutableStateOf<LatLng?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(53.35014, -6.266155), 12f) // Default location
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFCAA472))
                .padding(top = 50.dp, bottom = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Study Location",
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }

        // Google Map Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
        ) {
            // Google Map Composable
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                onMapClick = { latLng ->
                    selectedLocation = latLng
                    showDialog = true
                }
            )
        }

        // Selected Location Info
        selectedLocation?.let {
            Text(
                text = "Selected Location: ${it.latitude}, ${it.longitude}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.Black,
                fontSize = 16.sp,
            )
        }

        // Dialog for Confirming Address
        if (showDialog && selectedLocation != null) {
            ConfirmAddressDialog(
                latLng = selectedLocation!!,
                onDismiss = { showDialog = false },
                onConfirm = { address ->
                    Toast.makeText(context, "Address: $address", Toast.LENGTH_LONG).show()
                    showDialog = false
                }
            )
        }
    }
}

@Composable
fun ConfirmAddressDialog(
    latLng: LatLng,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    val context = LocalContext.current
    val address = remember(latLng) {
        getAddressFromLatLng(context, latLng)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Use this location?") },
        text = { Text("Address: $address") },
        confirmButton = {
            Button(onClick = { onConfirm(address) }) {
                Text("Select")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

fun getAddressFromLatLng(context: android.content.Context, latLng: LatLng): String {
    val geocoder = Geocoder(context, Locale.getDefault())
    return try {
        val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
        addresses?.firstOrNull()?.getAddressLine(0) ?: "Address not found"
    } catch (e: IOException) {
        "Error retrieving address"
    }
}

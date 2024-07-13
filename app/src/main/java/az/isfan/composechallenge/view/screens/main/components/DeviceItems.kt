package az.isfan.composechallenge.view.screens.main.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import az.isfan.composechallenge.domain.models.DeviceApiData

@Composable
fun DeviceItems(
    onButtonClick: (newTime: Boolean) -> Unit,
    timeToRequest: Boolean,
    devices: List<DeviceApiData>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(10.dp)
    ) {
        if (devices.isNotEmpty()) {
            items(devices) { device ->
                DeviceItem(
                    device = device
                )
            }
        }
        else {
            item {
                Text(
                    text = "No devices found"
                )
            }
        }

        item{
            Text(
                text = timeToRequest.toString()
            )
        }

        item{
            Button(onClick = {
                onButtonClick(!timeToRequest)
            }) {
                Text(text = "Request")
            }
        }
    }
}
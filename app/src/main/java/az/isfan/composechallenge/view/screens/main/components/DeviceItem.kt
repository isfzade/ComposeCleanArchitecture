package az.isfan.composechallenge.view.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import az.isfan.composechallenge.domain.models.DeviceApiData

@Composable
fun DeviceItem(
    device: DeviceApiData
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = (device.id ?: "-").toString()
        )

        Text(
            text = (device.name ?: "-").toString()
        )

        Text(
            text = device.dataToString()
        )
    }
}
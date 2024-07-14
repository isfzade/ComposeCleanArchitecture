package az.isfan.composechallenge.presentation.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import az.isfan.composechallenge.R
import az.isfan.composechallenge.domain.models.remote.DeviceApiData

@Composable
fun DeviceItem(
    device: DeviceApiData
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.device_id)+": "+(device.id ?: "-").toString()
        )

        Text(
            text = (device.name ?: "-").toString(),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = device.dataToString()
        )

        HorizontalDivider()
    }
}
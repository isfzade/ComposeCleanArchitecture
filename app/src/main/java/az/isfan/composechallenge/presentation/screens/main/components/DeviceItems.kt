package az.isfan.composechallenge.presentation.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.isfan.composechallenge.R
import az.isfan.composechallenge.domain.models.dto.DeviceDto
import az.isfan.composechallenge.domain.models.remote.DeviceApiData

@Composable
fun DeviceItems(
    onButtonClick: (newTime: Boolean) -> Unit,
    timeToRequest: Boolean,
    devices: List<DeviceDto>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item{
            Text(
                text = if (timeToRequest) stringResource(R.string.requested) else stringResource(R.string.not_requested),
                color = if (timeToRequest) Color.Green else Color.Red,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }

        item{
            Button(
                onClick = {
                    onButtonClick(!timeToRequest)
                },
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = if (devices.isEmpty()) stringResource(R.string.request) else stringResource(R.string.clear)
                )
            }
        }

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
                    text = stringResource(R.string.no_device),
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }
}
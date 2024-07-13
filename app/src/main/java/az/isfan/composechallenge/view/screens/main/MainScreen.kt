package az.isfan.composechallenge.view.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import az.isfan.composechallenge.view.screens.main.components.DeviceItems
import az.isfan.composechallenge.view.view_models.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val devices = viewModel.devices.collectAsStateWithLifecycle().value

    var timeToRequest by remember {
        mutableStateOf(false)
    }

    DeviceItems(
        onButtonClick = { newTime ->
            timeToRequest = newTime
        },
        timeToRequest = timeToRequest,
        devices = devices
    )

    LaunchedEffect(timeToRequest) {
        if (timeToRequest) viewModel.request()
        else viewModel.resetDevices()
    }
}
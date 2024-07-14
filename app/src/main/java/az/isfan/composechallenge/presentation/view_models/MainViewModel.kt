package az.isfan.composechallenge.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.isfan.composechallenge.domain.models.dto.DeviceDto
import az.isfan.composechallenge.domain.use_cases.RequestAndInsertDevicesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val requestAndInsertDevicesUseCase: RequestAndInsertDevicesUseCase
): ViewModel() {
    private var _devices = MutableStateFlow<List<DeviceDto>>(emptyList())
    var devices = _devices.asStateFlow()

    private var getDataJob: Job? = null

    fun resetDevices() {
        _devices.update { emptyList() }
    }

    fun request() {
        getDataJob?.cancel()
        getDataJob = viewModelScope.launch(Dispatchers.Default) {
            requestAndInsertDevicesUseCase
                .invoke()
                .collect{ dbDevices ->
                    _devices.update {
                        dbDevices
                    }
                }
        }
    }
}
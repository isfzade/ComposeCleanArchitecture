package az.isfan.composechallenge.view.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import az.isfan.composechallenge.domain.models.DeviceApiData
import az.isfan.composechallenge.domain.repos.ApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepo: ApiRepo
): ViewModel() {
    private var _devices = MutableStateFlow<List<DeviceApiData>>(emptyList())
    var devices = _devices.asStateFlow()

    private var requestJob: Job? = null

    fun request() {
        requestJob?.cancel()
        requestJob = viewModelScope.launch(Dispatchers.Default) {
            val response = withContext(Dispatchers.IO) {
                apiRepo.request()
            }
            if (response.isSuccessful) {
                response.body()?.let { deviceApiData ->
                    _devices.update {deviceApiData}
                }
            }
        }
    }
}
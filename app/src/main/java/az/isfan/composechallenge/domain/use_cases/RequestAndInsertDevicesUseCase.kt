package az.isfan.composechallenge.domain.use_cases

import az.isfan.composechallenge.data.mappers.toDeviceDto
import az.isfan.composechallenge.data.mappers.toDeviceEntity
import az.isfan.composechallenge.domain.models.dto.DeviceDto
import az.isfan.composechallenge.domain.repos.local.DeviceDbRepo
import az.isfan.composechallenge.domain.repos.remote.ApiRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RequestAndInsertDevicesUseCase @Inject constructor(
    private val apiRepo: ApiRepo,
    private val deviceDbRepo: DeviceDbRepo
){
    suspend fun invoke(): Flow<List<DeviceDto>> {
        val apiDevices = apiRepo.request()
        if (apiDevices.isNotEmpty()) {
            val entities = apiDevices.map { device -> device.toDeviceEntity() }
            entities.forEach { entity ->
                deviceDbRepo.insert(entity)
            }
        }
        return deviceDbRepo.getAll()
            .map { list ->
                list.map {
                    entity -> entity.toDeviceDto()
                }
            }
    }
}
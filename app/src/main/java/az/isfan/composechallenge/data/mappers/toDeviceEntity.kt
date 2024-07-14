package az.isfan.composechallenge.data.mappers

import az.isfan.composechallenge.domain.models.local.DeviceEntity
import az.isfan.composechallenge.domain.models.remote.DeviceApiData

fun DeviceApiData.toDeviceEntity(): DeviceEntity {
    return DeviceEntity(
        id = id.toInt(),
        name = name,
        data = dataToString()
    )
}
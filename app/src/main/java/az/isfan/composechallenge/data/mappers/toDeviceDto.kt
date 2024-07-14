package az.isfan.composechallenge.data.mappers

import az.isfan.composechallenge.domain.models.dto.DeviceDto
import az.isfan.composechallenge.domain.models.local.DeviceEntity
import az.isfan.composechallenge.domain.models.remote.DeviceApiData

fun DeviceEntity.toDeviceDto(): DeviceDto {
    return DeviceDto(
        id = id,
        name = name,
        data = data
    )
}
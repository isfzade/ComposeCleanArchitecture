package az.isfan.composechallenge.data.mappers

import az.isfan.composechallenge.domain.models.dto.DeviceDto
import az.isfan.composechallenge.domain.models.local.DeviceEntity

fun DeviceEntity.toDeviceDto(): DeviceDto {
    return DeviceDto(
        id = id,
        name = name,
        data = data
    )
}
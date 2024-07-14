package az.isfan.composechallenge.domain.repos.local

import az.isfan.composechallenge.domain.models.local.DeviceEntity
import kotlinx.coroutines.flow.Flow

interface DeviceDbRepo {
    suspend fun insert(device: DeviceEntity)

    suspend fun getAll(): Flow<List<DeviceEntity>>
}
package az.isfan.composechallenge.data.local.repo

import az.isfan.composechallenge.data.local.dao.DeviceDao
import az.isfan.composechallenge.domain.models.local.DeviceEntity
import az.isfan.composechallenge.domain.repos.local.DeviceDbRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeviceDbRepoImpl @Inject constructor(
    private val dao: DeviceDao
) : DeviceDbRepo {
    override suspend fun insert(device: DeviceEntity) {
        withContext(Dispatchers.IO) {
            dao.insert(device)
        }
    }

    override suspend fun getAll(): Flow<List<DeviceEntity>> {
        return withContext(Dispatchers.IO) {
            dao.getAll()
        }
    }
}
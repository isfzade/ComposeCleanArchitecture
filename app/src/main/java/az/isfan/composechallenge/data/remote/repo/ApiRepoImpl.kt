package az.isfan.composechallenge.data.remote.repo

import az.isfan.composechallenge.data.remote.RetrofitConnection
import az.isfan.composechallenge.domain.models.remote.DeviceApiData
import az.isfan.composechallenge.domain.repos.remote.ApiRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepoImpl: ApiRepo {
    override suspend fun request(): List<DeviceApiData> {
        try {
            val response = withContext(Dispatchers.IO) {
                RetrofitConnection.api.request()
            }
            if (!response.isSuccessful) return emptyList()
            return response.body() ?: emptyList()
        }
        catch (_: Exception) {
            return emptyList()
        }
    }
}
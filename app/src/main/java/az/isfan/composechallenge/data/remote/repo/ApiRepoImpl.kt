package az.isfan.composechallenge.data.remote.repo

import az.isfan.composechallenge.data.remote.RetrofitConnection
import az.isfan.composechallenge.domain.models.DeviceApiData
import az.isfan.composechallenge.domain.repos.ApiRepo
import retrofit2.Response
import javax.inject.Inject

class ApiRepoImpl @Inject constructor(
    private val retrofitConnection: RetrofitConnection
): ApiRepo {
    override suspend fun request(): Response<List<DeviceApiData>> {
        return retrofitConnection.api.request()
    }
}
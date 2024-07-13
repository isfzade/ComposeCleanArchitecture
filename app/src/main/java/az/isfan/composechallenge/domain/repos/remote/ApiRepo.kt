package az.isfan.composechallenge.domain.repos.remote

import az.isfan.composechallenge.domain.models.DeviceApiData
import retrofit2.Response

interface ApiRepo {
    suspend fun request(): Response<List<DeviceApiData>>
}
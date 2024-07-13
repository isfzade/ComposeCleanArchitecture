package az.isfan.composechallenge.data.remote.service

import az.isfan.composechallenge.domain.models.remote.DeviceApiData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("objects")
    suspend fun request(
    ): Response<List<DeviceApiData>>
}
package az.isfan.composechallenge.domain.repos.remote

import az.isfan.composechallenge.domain.models.remote.DeviceApiData

interface ApiRepo {
    suspend fun request(): List<DeviceApiData>
}
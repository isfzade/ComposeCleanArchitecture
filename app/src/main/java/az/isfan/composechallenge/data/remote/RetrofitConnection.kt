package az.isfan.composechallenge.data.remote

import az.isfan.composechallenge.data.remote.service.ApiService
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
class RetrofitConnection {
    private val BASE_URL = "https://api.restful-api.dev"

    private val client = OkHttpClient.Builder()
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
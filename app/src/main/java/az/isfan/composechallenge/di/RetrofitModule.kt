package az.isfan.composechallenge.di

import az.isfan.composechallenge.data.remote.RetrofitConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofitConnection(): RetrofitConnection = RetrofitConnection()
}
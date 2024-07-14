package az.isfan.composechallenge.di

import az.isfan.composechallenge.domain.repos.local.DeviceDbRepo
import az.isfan.composechallenge.domain.repos.remote.ApiRepo
import az.isfan.composechallenge.domain.use_cases.RequestAndInsertDevicesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideRequestAndInsertDevicesUseCase(
        apiRepo: ApiRepo,
        deviceDbRepo: DeviceDbRepo
    ): RequestAndInsertDevicesUseCase = RequestAndInsertDevicesUseCase(apiRepo, deviceDbRepo)
}
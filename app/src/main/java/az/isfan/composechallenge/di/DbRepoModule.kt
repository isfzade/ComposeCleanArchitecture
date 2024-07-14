package az.isfan.composechallenge.di

import az.isfan.composechallenge.data.local.dao.DeviceDao
import az.isfan.composechallenge.data.local.repo.DeviceDbRepoImpl
import az.isfan.composechallenge.domain.repos.local.DeviceDbRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DbRepoModule {
    @Singleton
    @Provides
    fun provideDeviceRepo(dao: DeviceDao): DeviceDbRepo = DeviceDbRepoImpl(dao)
}
package az.isfan.composechallenge.di

import az.isfan.composechallenge.data.remote.RetrofitConnection
import az.isfan.composechallenge.domain.repos.ApiRepo
import az.isfan.composechallenge.data.remote.repo.ApiRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiRepoModule {
    @Singleton
    @Provides
    fun provideApiRepo(retrofitConnection: RetrofitConnection): ApiRepo = ApiRepoImpl(retrofitConnection)
}
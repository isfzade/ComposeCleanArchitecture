package az.isfan.composechallenge.di

import az.isfan.composechallenge.data.remote.repo.ApiRepoImpl
import az.isfan.composechallenge.domain.repos.remote.ApiRepo
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
    fun provideApiRepo(): ApiRepo = ApiRepoImpl()
}
package az.isfan.composechallenge.di

import android.content.Context
import az.isfan.composechallenge.data.local.Db
import az.isfan.composechallenge.data.local.dao.DeviceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbDaoModule {
    @Singleton
    @Provides
    fun provideSettingsDao(@ApplicationContext context: Context): DeviceDao = Db.getDB(context).deviceDao()
}
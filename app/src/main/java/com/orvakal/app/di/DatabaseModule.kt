package com.orvakal.app.di

import android.content.Context
import androidx.room.Room
import com.orvakal.app.data.local.dao.ServiceDao
import com.orvakal.app.data.local.database.OrvikalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideOrvikalDatabase(
        @ApplicationContext context: Context
    ): OrvikalDatabase = Room.databaseBuilder(
        context,
        OrvikalDatabase::class.java,
        OrvikalDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideServiceDao(database: OrvikalDatabase): ServiceDao = database.serviceDao()
}

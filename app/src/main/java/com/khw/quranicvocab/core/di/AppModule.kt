package com.khw.quranicvocab.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khw.quranicvocab.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                AppDatabase.name
            ).fallbackToDestructiveMigration().build()
    }
}
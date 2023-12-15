package com.khw.quranicvocab.core.di

import com.khw.quranicvocab.data.database.AppDatabase
import com.khw.quranicvocab.data.repo.VocabRepo
import com.khw.quranicvocab.data.repo.VocabRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideVocabRepo(db: AppDatabase): VocabRepo {
        return VocabRepoImpl(db.vocabDao())
    }
}
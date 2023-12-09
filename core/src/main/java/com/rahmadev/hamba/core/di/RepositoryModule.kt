package com.rahmadev.hamba.core.di

import com.rahmadev.hamba.core.data.repository.DoaRepositoryImpl
import com.rahmadev.hamba.core.data.repository.HadithRepositoryImpl
import com.rahmadev.hamba.core.data.repository.QuranRepositoryImpl
import com.rahmadev.hamba.core.data.repository.ScheduleRepositoryImpl
import com.rahmadev.hamba.core.domain.repository.DoaRepository
import com.rahmadev.hamba.core.domain.repository.HadithRepository
import com.rahmadev.hamba.core.domain.repository.QuranRepository
import com.rahmadev.hamba.core.domain.repository.ScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository

    @Binds
    @Singleton
    abstract fun provideHadithRepository(hadithRepositoryImpl: HadithRepositoryImpl): HadithRepository

    @Binds
    @Singleton
    abstract fun provideDoaRepository(doaRepositoryImpl: DoaRepositoryImpl): DoaRepository

    @Binds
    @Singleton
    abstract fun provideQuranRepository(quranRepositoryImpl: QuranRepositoryImpl): QuranRepository
}
package com.rahmadev.hamba.core.di

import com.rahmadev.hamba.core.domain.usecase.doa.DoaInteract
import com.rahmadev.hamba.core.domain.usecase.doa.DoaUseCase
import com.rahmadev.hamba.core.domain.usecase.hadith.HadithInteract
import com.rahmadev.hamba.core.domain.usecase.hadith.HadithUseCase
import com.rahmadev.hamba.core.domain.usecase.prayer.PrayerTimesInteract
import com.rahmadev.hamba.core.domain.usecase.prayer.PrayerTimesUseCase
import com.rahmadev.hamba.core.domain.usecase.quran.QuranInteract
import com.rahmadev.hamba.core.domain.usecase.quran.QuranUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun providePrayerTimesUseCase(prayerTimesInteract: PrayerTimesInteract): PrayerTimesUseCase

    @Binds
    @Singleton
    abstract fun provideHadithUseCase(hadithInteract: HadithInteract): HadithUseCase

    @Binds
    @Singleton
    abstract fun provideDoaUseCase(doaInteract: DoaInteract): DoaUseCase

    @Binds
    @Singleton
    abstract fun provideQuranUseCase(quranInteract: QuranInteract): QuranUseCase
}
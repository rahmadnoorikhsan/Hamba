package com.rahmadev.hamba.core.domain.usecase.prayer

import com.rahmadev.hamba.core.domain.model.prayer.PrayerTimes
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface PrayerTimesUseCase {

    fun getPrayerTimes(city: String): Flow<Result<PrayerTimes>>
}
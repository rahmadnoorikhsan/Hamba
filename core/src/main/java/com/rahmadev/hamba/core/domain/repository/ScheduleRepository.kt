package com.rahmadev.hamba.core.domain.repository

import com.rahmadev.hamba.core.domain.model.prayer.PrayerTimes
import com.rahmadev.hamba.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {

    fun getTimeSchedule(city: String): Flow<Result<PrayerTimes>>
}
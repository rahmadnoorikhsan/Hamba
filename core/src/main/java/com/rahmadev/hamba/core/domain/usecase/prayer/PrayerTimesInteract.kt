package com.rahmadev.hamba.core.domain.usecase.prayer

import com.rahmadev.hamba.core.domain.repository.ScheduleRepository
import javax.inject.Inject

class PrayerTimesInteract @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : PrayerTimesUseCase {

    override fun getPrayerTimes(city: String) = scheduleRepository.getTimeSchedule(city)
}
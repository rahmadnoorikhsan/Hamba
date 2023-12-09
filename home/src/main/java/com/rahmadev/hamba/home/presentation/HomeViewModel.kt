package com.rahmadev.hamba.home.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rahmadev.hamba.core.domain.usecase.prayer.PrayerTimesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val prayerTimesUseCase: PrayerTimesUseCase
) : ViewModel() {

    val city = MutableLiveData<String>()

    fun getPrayerTimes(city: String) = prayerTimesUseCase.getPrayerTimes(city).asLiveData()
}
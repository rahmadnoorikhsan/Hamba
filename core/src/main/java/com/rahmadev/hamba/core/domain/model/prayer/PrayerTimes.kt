package com.rahmadev.hamba.core.domain.model.prayer

data class PrayerTimes(
    val sunset: String? = null,
    val asr: String? = null,
    val isha: String? = null,
    val fajr: String? = null,
    val dhuhr: String? = null,
    val maghrib: String? = null,
    val lastthird: String? = null,
    val firstthird: String? = null,
    val sunrise: String? = null,
    val midnight: String? = null,
    val imsak: String? = null
)

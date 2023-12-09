package com.rahmadev.hamba.core.data.source.network.response

import com.google.gson.annotations.SerializedName

data class PrayerScheduleResponse(
    @field:SerializedName("data")
	val data: Data,

    @field:SerializedName("status")
	val status: String? = null
)

data class Timings(

	@field:SerializedName("Sunset")
	val sunset: String? = null,

	@field:SerializedName("Asr")
	val asr: String? = null,

	@field:SerializedName("Isha")
	val isha: String? = null,

	@field:SerializedName("Fajr")
	val fajr: String? = null,

	@field:SerializedName("Dhuhr")
	val dhuhr: String? = null,

	@field:SerializedName("Maghrib")
	val maghrib: String? = null,

	@field:SerializedName("Lastthird")
	val lastthird: String? = null,

	@field:SerializedName("Firstthird")
	val firstthird: String? = null,

	@field:SerializedName("Sunrise")
	val sunrise: String? = null,

	@field:SerializedName("Midnight")
	val midnight: String? = null,

	@field:SerializedName("Imsak")
	val imsak: String? = null
)

data class Data(

    @field:SerializedName("timings")
	val timings: Timings
)
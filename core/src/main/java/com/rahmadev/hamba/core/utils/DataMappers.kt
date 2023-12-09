package com.rahmadev.hamba.core.utils

import com.rahmadev.hamba.core.data.source.network.response.AyatItem
import com.rahmadev.hamba.core.data.source.network.response.DetailSurahItemResponse
import com.rahmadev.hamba.core.data.source.network.response.DetailSurahResponse
import com.rahmadev.hamba.core.data.source.network.response.DoaResponseItem
import com.rahmadev.hamba.core.data.source.network.response.HadithResponseItem
import com.rahmadev.hamba.core.data.source.network.response.QuranItemResponse
import com.rahmadev.hamba.core.data.source.network.response.Timings
import com.rahmadev.hamba.core.domain.model.doa.Doa
import com.rahmadev.hamba.core.domain.model.hadith.Hadith
import com.rahmadev.hamba.core.domain.model.prayer.PrayerTimes
import com.rahmadev.hamba.core.domain.model.quran.Quran
import com.rahmadev.hamba.core.domain.model.quran.Surah
import com.rahmadev.hamba.core.domain.model.quran.Verses

fun Timings.toDomain(): PrayerTimes {
    return PrayerTimes(
        sunset = sunset,
        asr = asr,
        isha = isha,
        fajr = fajr,
        dhuhr = dhuhr,
        maghrib = maghrib,
        lastthird = lastthird,
        firstthird = firstthird,
        sunrise = sunrise
    )
}

fun HadithResponseItem.toDomain(): Hadith {
    return Hadith(
        number = number,
        arab = arab,
        translate = id
    )
}

fun DoaResponseItem.toDomain(): Doa {
    return Doa(
        id = id,
        title = judul,
        arab = arab,
        indonesian = latin,
        translate = terjemah
    )
}

fun QuranItemResponse.toDomain(): Quran {
    return Quran(
        number = nomor,
        name = nama,
        latin = namaLatin,
        translate = arti,
        totalAyah = jumlahAyat,
        type = tempatTurun
    )
}

fun DetailSurahItemResponse.toDomain(): Surah {
    return Surah(
        id = nomor,
        name = namaLatin,
        type = tempatTurun,
        translate = arti,
        audioFull = audioFull?.jsonMember01,
        verses = ayat.map { it.toDomain() },
    )
}

fun AyatItem.toDomain(): Verses {
    return Verses(
        id = nomorAyat,
        arabic = teksArab,
        audio = audio?.jsonMember01,
        indonesian = teksLatin,
        translate = teksIndonesia
    )
}
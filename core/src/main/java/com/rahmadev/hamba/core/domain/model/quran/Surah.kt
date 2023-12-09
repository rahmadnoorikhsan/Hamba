package com.rahmadev.hamba.core.domain.model.quran

data class Surah(
    val id: Int? = null,
    val name: String? = null,
    val type: String? = null,
    val translate: String? = null,
    val audioFull: String? = null,
    val verses: List<Verses> = emptyList(),
)

package com.rahmadev.hamba.core.domain.model.doa

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doa(
    val id: Int? = null,
    val title: String? = null,
    val arab: String? = null,
    val indonesian: String? = null,
    val translate: String? = null,
): Parcelable

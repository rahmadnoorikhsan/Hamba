package com.rahmadev.hamba.hadith

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rahmadev.hamba.core.domain.usecase.hadith.HadithUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HadithViewModel @Inject constructor(
    private val hadithUseCase: HadithUseCase
) : ViewModel() {

    fun getHadith() = hadithUseCase.getHadith().asLiveData()
}
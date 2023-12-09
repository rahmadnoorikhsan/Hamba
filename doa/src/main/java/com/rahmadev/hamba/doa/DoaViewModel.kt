package com.rahmadev.hamba.doa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rahmadev.hamba.core.domain.usecase.doa.DoaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoaViewModel @Inject constructor(
    private val doaUseCase: DoaUseCase
) : ViewModel() {

    fun getDoa() = doaUseCase.getDoa().asLiveData()
}
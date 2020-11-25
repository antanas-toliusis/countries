package com.antanas.demo.countries.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antanas.demo.domain.usecase.GetCountriesUseCase
import kotlinx.coroutines.launch
import library.core.extensions.logTimberWithTag
import library.core.uistate.UIState

class MainViewModel @ViewModelInject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    fun onRetryBtnClicked() {
    }

    private var _liveData = MutableLiveData<UIState<List<Any>>>()
    val liveData: LiveData<UIState<List<Any>>> = _liveData

    init {
        viewModelScope.launch {
            getCountriesUseCase().let {
                logTimberWithTag("received $it")
            }
        }
    }
}

package com.antanas.demo.countries.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import library.core.uistate.UIState

class MainViewModel @ViewModelInject constructor() : ViewModel() {

    private var _liveData = MutableLiveData<UIState<List<Any>>>()
    val liveData: LiveData<UIState<List<Any>>> = _liveData

    init {
        viewModelScope.launch {
        }
    }
}

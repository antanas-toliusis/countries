package com.antanas.demo.countries.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.usecase.GetCountriesUseCase
import com.antanas.demo.domain.usecase.SearchCountriesUseCase
import kotlinx.coroutines.launch
import library.core.uistate.UIState
import library.core.uistate.UIState.Loading
import library.core.uistate.mapToUiState

class MainViewModel @ViewModelInject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val searchCountriesUseCase: SearchCountriesUseCase
) : ViewModel() {

    private var _liveData = MutableLiveData<UIState<List<CountryEntity>>>()
    val liveData: LiveData<UIState<List<CountryEntity>>> = _liveData

    fun onRetryBtnClicked() {
        loadAllCountries()
    }

    fun loadAllCountries() {
        _liveData.postValue(Loading())

        viewModelScope.launch {
            getCountriesUseCase().mapToUiState().let {
                _liveData.postValue(it)
            }
        }
    }

    fun onSearch(text: String) {
        viewModelScope.launch {
            searchCountriesUseCase(text).mapToUiState().let {
                _liveData.postValue(it)
            }
        }
    }
}

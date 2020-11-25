package com.antanas.demo.domain.usecase

import com.antanas.demo.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {
    suspend operator fun invoke() {
        withContext(Dispatchers.IO) {
            repository.getCountries()
        }
    }
}

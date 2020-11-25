package com.antanas.demo.domain.usecase

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {
    suspend operator fun invoke(): DomainResult<List<CountryEntity>> =
        withContext(Dispatchers.IO) {
            repository.getCountries()
        }
}

package com.antanas.demo.domain.usecase

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.repository.CountriesRepository
import javax.inject.Inject

class SearchCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {

    suspend operator fun invoke(query: String): DomainResult<List<CountryEntity>> =
        repository.searchCountries(query)
}

package com.antanas.demo.domain.usecase

import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.repository.CountriesRepository
import javax.inject.Inject

class SearchCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
) {

    operator fun invoke(query: String): List<CountryEntity> = TODO()
}

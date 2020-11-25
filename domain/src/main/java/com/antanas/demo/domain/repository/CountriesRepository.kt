package com.antanas.demo.domain.repository

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity

interface CountriesRepository {

    suspend fun getCountries(): DomainResult<List<CountryEntity>>
}

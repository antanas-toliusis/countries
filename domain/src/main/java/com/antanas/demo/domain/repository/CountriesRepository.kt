package com.antanas.demo.domain.repository

import com.antanas.demo.domain.DomainResult

interface CountriesRepository {

    suspend fun getCountries(): DomainResult<List<Any>>
}

package com.antanas.demo.countries.main

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.entities.Currency

fun mockedDomainResultWithCountriesList(): DomainResult<List<CountryEntity>> =
    DomainResult.Success(mockedCountryEntities())

fun mockedCountryEntities() = listOf(
    CountryEntity(
        name = "UK",
        flagUrl = "flagUrl",
        capital = "capital",
        currencies = listOf(
            Currency(
                name = "name",
                code = "code"
            )
        )
    )
)

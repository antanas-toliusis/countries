package com.antanas.demo.data.mapping

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.entities.Currency
import library.database.model.LocalCountry
import library.database.model.LocalCurrency

fun List<LocalCountry>.mapLocalToDomainCountries(): DomainResult<List<CountryEntity>> =
    map {
        CountryEntity(
            name = it.name,
            flagUrl = it.flagUrl,
            capital = it.capital,
            currencies = it.currencies.mapToCurrencies()
        )
    }.let {
        DomainResult.Success(it)
    }

private fun List<LocalCurrency>.mapToCurrencies(): List<Currency> =
    map {
        Currency(
            name = it.name,
            code = it.code
        )
    }

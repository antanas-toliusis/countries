package com.antanas.demo.data.mapping

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.entities.Currency
import library.database.model.LocalCountry
import library.database.model.LocalCurrency
import library.network.model.RemoteCountry
import library.network.model.RemoteCurrency
import library.network.result.RemoteResult

fun RemoteResult<List<RemoteCountry>>.mapToDomainResultCountries(): DomainResult<List<CountryEntity>> =
    mapToDomainResult {
        DomainResult.Success(
            it.map { remoteCountry ->
                CountryEntity(
                    name = remoteCountry.name ?: "",
                    flagUrl = remoteCountry.flag ?: "",
                    capital = remoteCountry.capital ?: "",
                    currencies = remoteCountry.currencies?.mapToCurrencies() ?: emptyList()
                )
            }
        )
    }

fun RemoteResult<List<RemoteCountry>>.mapToLocalCountries(): List<LocalCountry> =
    when (this) {
        is RemoteResult.Success -> {
            this.data.map {
                LocalCountry(
                    name = it.name ?: "",
                    flagUrl = it.flag ?: "",
                    capital = it.capital ?: "",
                    currencies = it.currencies?.mapToLocalCurrencies() ?: emptyList()
                )
            }
        }
        is RemoteResult.Failure -> emptyList()
    }

private fun List<RemoteCurrency?>.mapToCurrencies(): List<Currency> =
    map {
        Currency(
            name = it?.name ?: "",
            code = it?.code ?: ""
        )
    }

private fun List<RemoteCurrency?>.mapToLocalCurrencies(): List<LocalCurrency> =
    map {
        LocalCurrency(
            name = it?.name ?: "",
            code = it?.code ?: ""
        )
    }

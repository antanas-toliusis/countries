package com.antanas.demo.data.mapping

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.entities.Currency
import library.network.model.RemoteCountry
import library.network.model.RemoteCurrency
import library.network.result.RemoteResult

fun RemoteResult<List<RemoteCountry>>.mapToDomainCountriesResult(): DomainResult<List<CountryEntity>> =
    mapToDomainResult { response ->
        response.remoteSuccessMapper { countries ->
            countries.map {
                CountryEntity(
                    name = it?.name ?: "",
                    flagUrl = it?.flag ?: "",
                    capital = it?.capital ?: "",
                    currencies = it?.currencies?.mapToCurrencies() ?: emptyList()
                )
            }
        }
    }

private fun List<RemoteCurrency?>.mapToCurrencies(): List<Currency> =
    map {
        Currency(
            name = it?.name ?: "",
            code = it?.code ?: ""
        )
    }

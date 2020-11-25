package com.antanas.demo.data.repository

import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.repository.CountriesRepository
import library.core.extensions.logTimberWithTag
import library.network.datasource.RemoteCountriesDatasource
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val remoteCountriesDatasource: RemoteCountriesDatasource
) : CountriesRepository {

    override suspend fun getCountries(): DomainResult<List<Any>> {
        remoteCountriesDatasource.getCountries().run {
            logTimberWithTag("got results $this")
        }
        return DomainResult.Empty()
    }
}

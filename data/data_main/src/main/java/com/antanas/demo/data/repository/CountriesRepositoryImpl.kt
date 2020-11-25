package com.antanas.demo.data.repository

import com.antanas.demo.data.mapping.mapToDomainCountriesResult
import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.repository.CountriesRepository
import library.network.datasource.RemoteCountriesDatasource
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val remoteCountriesDatasource: RemoteCountriesDatasource
) : CountriesRepository {

    override suspend fun getCountries(): DomainResult<List<CountryEntity>> =
        remoteCountriesDatasource.getCountries().run {
            mapToDomainCountriesResult()
        }
}

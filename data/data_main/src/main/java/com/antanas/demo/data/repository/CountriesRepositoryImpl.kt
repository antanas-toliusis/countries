package com.antanas.demo.data.repository

import com.antanas.demo.data.mapping.mapToDomainResultCountries
import com.antanas.demo.data.mapping.mapToLocalCountries
import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.entities.CountryEntity
import com.antanas.demo.domain.repository.CountriesRepository
import library.database.datasource.LocalCountriesDataSource
import library.network.datasource.RemoteCountriesDataSource
import library.network.model.RemoteCountry
import library.network.result.RemoteResult
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalCountriesDataSource,
    private val remoteDataSource: RemoteCountriesDataSource
) : CountriesRepository {

    override suspend fun getCountries(): DomainResult<List<CountryEntity>> =
        localDataSource.getCountries().run {
            if (isNotEmpty()) {
                mapToDomainResultCountries()
            } else {
                fetchRemoteCountries()
            }
        }

    private suspend fun fetchRemoteCountries(): DomainResult<List<CountryEntity>> =
        remoteDataSource.getCountries().let { result ->
            result.mapToDomainResultCountries().also { domainResult ->
                if (domainResult is DomainResult.Success<List<CountryEntity>>) {
                    saveRemoteResultToDB(result)
                }
            }
        }

    private suspend fun saveRemoteResultToDB(result: RemoteResult<List<RemoteCountry>>) {
        result.mapToLocalCountries().let {
            localDataSource.insertCounties(it)
        }
    }
}

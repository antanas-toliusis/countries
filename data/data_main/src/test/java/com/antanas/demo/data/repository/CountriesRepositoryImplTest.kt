package com.antanas.demo.data.repository

import com.antanas.demo.data.mocks.mockedLocalCountries
import com.antanas.demo.data.mocks.mockedRemoteCountries
import com.antanas.demo.domain.DomainResult
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import library.database.datasource.LocalCountriesDataSource
import library.network.datasource.RemoteCountriesDataSource
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class CountriesRepositoryImplTest {

    private val localDataSource: LocalCountriesDataSource = mock()
    private val remoteDataSource: RemoteCountriesDataSource = mock()
    private lateinit var repositoryUnderTest: CountriesRepositoryImpl

    @Before
    fun setUp() {
        repositoryUnderTest = CountriesRepositoryImpl(localDataSource, remoteDataSource)
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(localDataSource, remoteDataSource)
    }

    @Test
    fun `given db contains countries then return from db`() {
        runBlocking {
            whenever(localDataSource.getCountries()).thenReturn(mockedLocalCountries())

            repositoryUnderTest.getCountries().let {
                assertTrue(it is DomainResult.Success && it.data.isNotEmpty())
            }
            verify(localDataSource).getCountries()
            verify(remoteDataSource, never()).getCountries()
        }
    }

    @Test
    fun `given db countries are empty then fetch from api, save to db, and return domain result`() {
        runBlocking {
            whenever(localDataSource.getCountries()).thenReturn(emptyList())
            whenever(remoteDataSource.getCountries()).thenReturn(mockedRemoteCountries())

            repositoryUnderTest.getCountries().let {
                assertTrue(it is DomainResult.Success && it.data.isNotEmpty())
            }
            verify(remoteDataSource).getCountries()
            verify(localDataSource).getCountries()
            verify(localDataSource).insertCounties(any())
        }
    }

    @Test
    fun `given db countries name starts as search query then return found result`() {
        runBlocking {
            whenever(localDataSource.searchCountries("UK")).thenReturn(mockedLocalCountries())

            repositoryUnderTest.searchCountries("UK").let {
                assertTrue { it is DomainResult.Success && it.data[0].name == "UK" }
            }
            verify(localDataSource).searchCountries("UK")
        }
    }
}

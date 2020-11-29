package com.antanas.demo.countries.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.antanas.demo.domain.DomainResult
import com.antanas.demo.domain.usecase.GetCountriesUseCase
import com.antanas.demo.domain.usecase.SearchCountriesUseCase
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import library.core.uistate.UIState
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val getCountriesUseCase: GetCountriesUseCase = mock()
    private val searchCountriesUseCase: SearchCountriesUseCase = mock()

    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var viewModelUnderTest: MainViewModel

    @Before
    fun setUp() = testDispatcher.runBlockingTest {
        viewModelUnderTest = MainViewModel(getCountriesUseCase, searchCountriesUseCase)
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(getCountriesUseCase, searchCountriesUseCase)
    }

    @Test
    fun loadingCountriesSuccessfully_ShowsData() =
        testDispatcher.runBlockingTest {
            whenever(getCountriesUseCase()).thenReturn(mockedDomainResultWithCountriesList())
            viewModelUnderTest.loadAllCountries()

            with(viewModelUnderTest.liveData.test()) {
                assertValue(UIState.Success(mockedCountryEntities()))
            }
            verify(getCountriesUseCase).invoke()
        }

    @Test
    fun loadingCountriesWithoutInternet_ShowsNoConnection() =
        testDispatcher.runBlockingTest {
            whenever(getCountriesUseCase()).thenReturn(DomainResult.ConnectionError())
            viewModelUnderTest.loadAllCountries()

            viewModelUnderTest.liveData.test().let {
                assertTrue { it.value() is UIState.ConnectionError }
            }
            verify(getCountriesUseCase).invoke()
        }

    @Test
    fun givenLoadingCountriesReturnsUnknownError_ThenShowNoConnection() =
        testDispatcher.runBlockingTest {
            whenever(getCountriesUseCase()).thenReturn(DomainResult.UnknownError())
            viewModelUnderTest.loadAllCountries()

            viewModelUnderTest.liveData.test().let {
                assertTrue { it.value() is UIState.UnknownError }
            }
            verify(getCountriesUseCase).invoke()
        }

    @Test
    fun givenOnRefreshDataCalled_ThenGetCountriesUseCaseIsInvoked() {
        testDispatcher.runBlockingTest {
            whenever(getCountriesUseCase()).thenReturn(mockedDomainResultWithCountriesList())
            viewModelUnderTest.onRetryBtnClicked()

            verify(getCountriesUseCase).invoke()
        }
    }

    @Test
    fun givenSearchingWithValidData__ShowsData() {
        testDispatcher.runBlockingTest {
            whenever(searchCountriesUseCase("UK")).thenReturn(mockedDomainResultWithCountriesList())
            viewModelUnderTest.onSearch("UK")

            viewModelUnderTest.liveData.test().let {
                assertTrue { it.value() is UIState.Success }
            }
            verify(searchCountriesUseCase).invoke("UK")
        }
    }
}

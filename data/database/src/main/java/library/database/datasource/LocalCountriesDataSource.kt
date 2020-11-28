package library.database.datasource

import library.database.CountriesDao
import library.database.model.LocalCountry
import javax.inject.Inject

class LocalCountriesDataSource @Inject constructor(
    private val dao: CountriesDao
) {

    suspend fun insertCounties(countries: List<LocalCountry>) = dao.insertCountries(countries)

    suspend fun getCountries(): List<LocalCountry> = dao.getCountries()

    suspend fun searchCountries(query: String): List<LocalCountry> = dao.searchCountries(query)
}

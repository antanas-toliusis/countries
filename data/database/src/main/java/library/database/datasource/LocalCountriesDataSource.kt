package library.database.datasource

import library.database.AppDao
import library.database.model.LocalCountry
import javax.inject.Inject

class LocalCountriesDataSource @Inject constructor(
    private val appDao: AppDao
) {

    suspend fun insertCounties(countries: List<LocalCountry>) =
        appDao.insertCountries(countries)

    suspend fun getCountries(): List<LocalCountry> =
        appDao.getCountries()
}

package library.network.datasource

import library.network.ApiService
import library.network.model.RemoteCountry
import library.network.result.RemoteResult
import library.network.safeApiCallToRemoteResult
import javax.inject.Inject

class RemoteCountriesDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountries(): RemoteResult<List<RemoteCountry>> =
        safeApiCallToRemoteResult {
            apiService.fetchCountries()
        }
}

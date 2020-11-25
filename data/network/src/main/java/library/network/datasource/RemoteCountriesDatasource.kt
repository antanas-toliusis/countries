package library.network.datasource

import library.network.ApiService
import library.network.model.RemoteCountry
import library.network.result.RemoteResult
import library.network.safeApiCallToRemoteResultMapper
import javax.inject.Inject

class RemoteCountriesDatasource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCountries(): RemoteResult<List<RemoteCountry>> =
        safeApiCallToRemoteResultMapper {
            apiService.fetchCountries()
        }
}

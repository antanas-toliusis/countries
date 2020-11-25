package library.network

import library.network.model.RemoteCountry
import retrofit2.http.GET

interface ApiService {

    @GET("v2/all")
    suspend fun fetchCountries(): List<RemoteCountry>
}

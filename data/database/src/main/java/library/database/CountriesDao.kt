package library.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import library.database.model.LocalCountry

@Dao
interface CountriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<LocalCountry>)

    @Query("SELECT * FROM LocalCountry")
    suspend fun getCountries(): List<LocalCountry>

    @Query("SELECT * FROM LocalCountry WHERE name LIKE :countryName || '%'")
    suspend fun searchCountries(countryName: String): List<LocalCountry>
}

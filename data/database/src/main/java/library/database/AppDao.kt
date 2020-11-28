package library.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import library.database.model.LocalCountry

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<LocalCountry>)

    @Query("SELECT * FROM LocalCountry")
    suspend fun getCountries(): List<LocalCountry>

    @Query("SELECT * FROM LocalCountry WHERE name=:countryName")
    suspend fun getCountriesByName(countryName: String): List<LocalCountry>
}

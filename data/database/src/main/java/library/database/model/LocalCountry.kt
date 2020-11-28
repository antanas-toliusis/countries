package library.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalCountry(
    @PrimaryKey
    val name: String,
    val flagUrl: String,
    val capital: String,
    val currencies: List<LocalCurrency>
)

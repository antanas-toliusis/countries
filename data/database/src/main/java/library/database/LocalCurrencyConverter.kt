package library.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import library.core.extensions.fromJsonTypeToken
import library.database.model.LocalCurrency

class LocalCurrencyConverter {

    @TypeConverter
    fun fromLocalCurrency(currencies: List<LocalCurrency>): String = Gson().toJson(currencies)

    @TypeConverter
    fun toLocalCurrency(data: String): List<LocalCurrency> = Gson().fromJsonTypeToken(data)
}

package library.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import library.database.model.LocalCountry

@Database(entities = [LocalCountry::class], version = 1)
@TypeConverters(LocalCurrencyConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao
}

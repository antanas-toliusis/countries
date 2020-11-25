package library.database

import androidx.room.Database
import androidx.room.RoomDatabase
import library.database.model.DBTodo

@Database(entities = [DBTodo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao
}

package library.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import library.database.AppDatabase
import library.database.CountriesDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CountriesDao =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "app_database.db")
            .build()
            .countriesDao()
}

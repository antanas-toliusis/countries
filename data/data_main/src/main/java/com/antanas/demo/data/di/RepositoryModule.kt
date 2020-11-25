package com.antanas.demo.data.di

import com.antanas.demo.data.repository.CountriesRepositoryImpl
import com.antanas.demo.domain.repository.CountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindCountriesRepository(repositoryImpl: CountriesRepositoryImpl): CountriesRepository
}

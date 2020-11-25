package com.antanas.demo.domain.usecase

import com.antanas.demo.domain.repository.CountriesRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountriesRepository
)

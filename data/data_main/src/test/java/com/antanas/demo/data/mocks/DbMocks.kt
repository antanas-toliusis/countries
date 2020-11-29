package com.antanas.demo.data.mocks

import library.database.model.LocalCountry
import library.database.model.LocalCurrency

fun mockedLocalCountries(): List<LocalCountry> = listOf(
    LocalCountry(
        name = "UK",
        flagUrl = "flagUrl",
        capital = "capital",
        currencies = listOf(
            LocalCurrency(
                name = "name",
                code = "code"
            )
        )
    )
)

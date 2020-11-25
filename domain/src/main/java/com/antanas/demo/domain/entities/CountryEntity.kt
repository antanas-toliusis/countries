package com.antanas.demo.domain.entities

data class CountryEntity(
    val name: String,
    val flagUrl: String,
    val capital: String,
    val currencies: List<Currency>
)

data class Currency(
    val name: String,
    val symbol: String
)

package com.antanas.demo.domain.entities

import java.io.Serializable

data class CountryEntity(
    val name: String,
    val flagUrl: String,
    val capital: String,
    val currencies: List<Currency>
) : Serializable

data class Currency(
    val name: String,
    val code: String
) : Serializable

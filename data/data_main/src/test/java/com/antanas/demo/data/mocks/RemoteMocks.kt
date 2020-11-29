package com.antanas.demo.data.mocks

import library.core.extensions.fromJsonFile
import library.network.model.RemoteCountry
import library.network.result.RemoteResult

fun mockedRemoteCountries(): RemoteResult.Success<List<RemoteCountry>> =
    RemoteResult.Success(
        listOf(fromJsonFile("single_remote_country.json"))
    )

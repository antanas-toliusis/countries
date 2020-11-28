package com.antanas.demo.data.mapping

import com.antanas.demo.domain.DomainResult
import library.core.extensions.exhaustive
import library.network.result.RemoteError
import library.network.result.RemoteResult

fun <I, O> RemoteResult<I>.mapToDomainResult(onSuccess: (I) -> DomainResult<O>): DomainResult<O> =
    when (this) {
        is RemoteResult.Success -> onSuccess(data)
        is RemoteResult.Failure -> {
            when (remoteError) {
                is RemoteError.ConnectionError -> DomainResult.ConnectionError<O>()
                is RemoteError.UnexpectedError -> DomainResult.UnknownError()
            }.exhaustive
        }
    }.exhaustive

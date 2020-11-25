package com.antanas.demo.data.mapping

import com.antanas.demo.domain.DomainResult
import library.core.extensions.exhaustive
import library.network.result.RemoteError
import library.network.result.RemoteResult

fun <I, O> RemoteResult<I>.mapToDomainResult(convert: (I) -> DomainResult<O>): DomainResult<O> =
    when (this) {
        is RemoteResult.Success -> convert(data)
        is RemoteResult.Failure -> {
            when (remoteError) {
                is RemoteError.ConnectionError -> DomainResult.ConnectionError<O>()
                is RemoteError.UnexpectedError -> DomainResult.Empty()
            }.exhaustive
        }
    }.exhaustive

fun <I, O> List<I>?.remoteSuccessMapper(convert: (List<I?>) -> List<O>): DomainResult<List<O>> =
    this?.let {
        convert(it).mapToDomainResultSuccessOrEmpty()
    } ?: DomainResult.Empty()

private fun <T> List<T>.mapToDomainResultSuccessOrEmpty(): DomainResult<List<T>> {
    return if (isEmpty()) {
        DomainResult.Empty()
    } else {
        DomainResult.Success(this)
    }
}

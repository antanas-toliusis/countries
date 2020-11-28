package library.network

import library.network.result.RemoteError
import library.network.result.RemoteResult
import java.io.IOException

private typealias Success<T> = RemoteResult.Success<T>
private typealias Failure<T> = RemoteResult.Failure<T>
private typealias Connection = RemoteError.ConnectionError
private typealias Unexpected = RemoteError.UnexpectedError

suspend fun <T> safeApiCallToRemoteResult(call: suspend () -> T): RemoteResult<T> {
    return runCatching {
        call()
    }.fold(
        { Success(it) },
        {
            when (it) {
                is IOException -> Failure(Connection(it.toString()))
                else -> Failure(Unexpected(it.toString()))
            }
        }
    )
}

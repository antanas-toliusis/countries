package library.network.result

sealed class RemoteResult<out T> {
    data class Success<out T>(val data: T) : RemoteResult<T>()
    data class Failure<T>(val remoteError: RemoteError) : RemoteResult<T>()
}

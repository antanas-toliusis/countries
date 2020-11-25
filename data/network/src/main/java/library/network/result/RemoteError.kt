package library.network.result

sealed class RemoteError {
    data class ConnectionError(val msg: String) : RemoteError()
    data class UnexpectedError(val msg: String) : RemoteError()
}

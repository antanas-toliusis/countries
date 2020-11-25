package library.core.uistate

sealed class UIState<out R> {
    class Loading<T> : UIState<T>()
    data class Success<T>(val data: T) : UIState<T>()
    class ConnectionError<T> : UIState<T>()
    class Empty<T> : UIState<T>()
}

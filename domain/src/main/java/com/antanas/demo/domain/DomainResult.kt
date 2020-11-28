package com.antanas.demo.domain

sealed class DomainResult<out T> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    class UnknownError<T> : DomainResult<T>()
    class ConnectionError<T> : DomainResult<T>()
}

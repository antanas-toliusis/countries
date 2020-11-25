package library.core.uistate

import com.antanas.demo.domain.DomainResult
import library.core.extensions.exhaustive

fun <T> DomainResult<T>.mapToUiState(): UIState<T> =
    when (this) {
        is DomainResult.Success -> UIState.Success(data)
        is DomainResult.Empty -> UIState.Empty()
        is DomainResult.ConnectionError -> UIState.ConnectionError()
    }.exhaustive

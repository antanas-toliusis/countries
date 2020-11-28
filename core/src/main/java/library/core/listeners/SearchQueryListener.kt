package library.core.listeners

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchQueryListener(
    val lifecycle: Lifecycle,
    private val onTextChange: (String) -> Unit
) :
    SearchView.OnQueryTextListener {
    private val coroutineScope = lifecycle.coroutineScope
    private var searchJob: Job? = null

    override fun onQueryTextSubmit(query: String) = true

    override fun onQueryTextChange(newText: String): Boolean {
        searchJob?.cancel()
        searchJob = coroutineScope.launch { onTextChange(newText) }
        return false
    }
}

package library.core.listeners

import androidx.appcompat.widget.SearchView

class OnQueryListener(private val onTextChange: (String) -> Unit) :
    SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String) = true

    override fun onQueryTextChange(newText: String): Boolean {
        onTextChange(newText)
        return false
    }
}

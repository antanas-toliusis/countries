package library.core.extensions.view

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addItemDecoration(@Px spacing: Int) {
    setPadding(spacing, spacing, spacing, spacing)
    clipToPadding = false
    clipChildren = false
    addItemDecoration(
        object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.set(spacing, spacing, spacing, spacing)
            }
        }
    )
}

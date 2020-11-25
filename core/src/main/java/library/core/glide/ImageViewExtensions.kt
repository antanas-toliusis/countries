package library.core.glide

import android.widget.ImageView

fun ImageView.load(url: String) {
    GlideApp
        .with(this)
        .load(url)
        .centerCrop()
        .into(this)
}

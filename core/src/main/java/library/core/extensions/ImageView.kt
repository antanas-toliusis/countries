package library.core.extensions

import android.net.Uri
import android.widget.ImageView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

fun ImageView.loadSwg(url: String) {
    GlideToVectorYou
        .init()
        .with(context)
        .load(Uri.parse(url), this)
}

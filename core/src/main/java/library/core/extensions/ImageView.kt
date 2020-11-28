package library.core.extensions

import android.net.Uri
import android.widget.ImageView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import library.core.R

fun ImageView.loadSwg(url: String) {
    GlideToVectorYou
        .init()
        .with(context)
        .setPlaceHolder(R.drawable.ic_baseline_flag_24, R.drawable.ic_baseline_flag_24)
        .load(Uri.parse(url), this)
}

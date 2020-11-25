package library.core.extensions

import timber.log.Timber

fun logTimberWithTag(msg: Any, tag: String = "TIMBER_DEBUG_TAG") {
    Timber.tag(tag).d(msg.toString())
}

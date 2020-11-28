package library.core.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import library.core.R
import library.core.databinding.LoadingCompundViewBinding
import library.core.extensions.exhaustive
import library.core.extensions.view.setGone
import library.core.extensions.view.setVisible
import library.core.extensions.view.snack
import library.core.views.LoadingState.HideAllViews
import library.core.views.LoadingState.Loading
import library.core.views.LoadingState.OnConnectionError
import library.core.views.LoadingState.UnknownError

class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var binding: LoadingCompundViewBinding =
        LoadingCompundViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setState(HideAllViews)
    }

    fun setOnRetryClickListener(listener: OnClickListener) {
        binding.retryBtn.setOnClickListener(listener)
    }

    fun setState(state: LoadingState) {
        with(binding) {
            when (state) {
                HideAllViews -> {
                    progressBar.setGone()
                    errorMsgView.setGone()
                    retryBtn.setGone()
                }
                Loading -> {
                    progressBar.setVisible()
                    errorMsgView.setGone()
                    retryBtn.setGone()
                }
                OnConnectionError -> {
                    snack(context.getString(R.string.err_msg_no_internet_connection))
                    retryBtn.setVisible()
                    progressBar.setGone()
                    errorMsgView.setGone()
                }
                UnknownError -> {
                    errorMsgView.text = context.getString(R.string.err_msg_no_content)
                    errorMsgView.setVisible()
                    progressBar.setGone()
                    retryBtn.setGone()
                }
            }.exhaustive
        }
    }
}

sealed class LoadingState {
    object HideAllViews : LoadingState()
    object Loading : LoadingState()
    object OnConnectionError : LoadingState()
    object UnknownError : LoadingState()
}

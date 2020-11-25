package com.antanas.demo.countries.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import library.core.extensions.exhaustive
import library.core.extensions.fragment.viewBinding
import library.core.uistate.UIState
import library.core.views.LoadingState.HideAllViews
import library.core.views.LoadingState.Loading
import library.core.views.LoadingState.OnConnectionError
import library.core.views.LoadingState.OnEmptyError

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val mainAdapter = MainAdapter { country, _ ->
        navigateToDetails()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
        observeLiveData()
    }

    private fun setUi() {
        with(binding) {
            recyclerView.run {
                adapter = mainAdapter
                layoutManager = LinearLayoutManager(context)
            }

            loadingView.setOnRetryClickListener {
                viewModel.onRetryBtnClicked()
            }
        }
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(
            viewLifecycleOwner,
            { uiState ->
                when (uiState) {
                    is UIState.Loading -> {
                        binding.loadingView.setState(Loading)
                    }
                    is UIState.Success -> {
                        binding.loadingView.setState(HideAllViews)
                        mainAdapter.setData(uiState.data)
                    }
                    is UIState.ConnectionError -> {
                        binding.loadingView.setState(OnConnectionError)
                    }
                    is UIState.Empty -> {
                        binding.loadingView.setState(OnEmptyError)
                    }
                }.exhaustive
            }
        )
    }

    private fun navigateToDetails() {}
}

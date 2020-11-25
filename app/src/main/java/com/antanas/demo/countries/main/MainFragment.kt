package com.antanas.demo.countries.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import library.core.extensions.exhaustive
import library.core.extensions.fragment.viewBinding
import library.core.uistate.UIState

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(
            viewLifecycleOwner,
            { uiState ->
                when (uiState) {
                    is UIState.Loading -> {
                    }
                    is UIState.Success -> {
                    }
                    is UIState.ConnectionError -> {
                    }
                    is UIState.Empty -> {
                    }
                }.exhaustive
            }
        )
    }
}

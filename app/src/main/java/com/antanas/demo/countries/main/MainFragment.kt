package com.antanas.demo.countries.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.FragmentMainBinding
import com.antanas.demo.domain.entities.CountryEntity
import dagger.hilt.android.AndroidEntryPoint
import library.core.extensions.exhaustive
import library.core.extensions.fragment.viewBinding
import library.core.listeners.OnQueryListener
import library.core.uistate.UIState
import library.core.views.LoadingState.HideAllViews
import library.core.views.LoadingState.Loading
import library.core.views.LoadingState.OnConnectionError
import library.core.views.LoadingState.UnknownError

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val mainAdapter = MainAdapter { country, _ ->
        onCountryItemClick(country)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setLoadingView()
        setSearchView()
        observeLiveData()
    }

    private fun setRecyclerView() = binding.recyclerView
        .run {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
        }

    private fun setLoadingView() = binding.loadingView
        .setOnRetryClickListener {
            viewModel.onRetryBtnClicked()
        }

    private fun setSearchView() = binding.appBar.searchView
        .setOnQueryTextListener(
            OnQueryListener { viewModel.onSearch(it) }
        )

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
                    is UIState.UnknownError -> {
                        binding.loadingView.setState(UnknownError)
                    }
                }.exhaustive
            }
        )
    }

    private fun onCountryItemClick(country: CountryEntity) = binding.appBar.searchView
        .run {
            clearFocus()
            navigateToDetails(country)
        }

    private fun navigateToDetails(countryEntity: CountryEntity) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToDetailsFragment(
                countryEntity
            )
        )
    }
}

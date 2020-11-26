package com.antanas.demo.countries.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import library.core.extensions.fragment.viewBinding
import library.core.extensions.loadSwg

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val country by lazy {
        navArgs<DetailsFragmentArgs>().value.countryEntity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    private fun setUi() {
        with(binding) {
            image.loadSwg(country.flagUrl)
            name.text = country.name
            capital.text = getString(R.string.details_page_capital, country.capital)

            recyclerView.run {
                layoutManager = LinearLayoutManager(context)
                adapter = CurrenciesAdapter(currencies = country.currencies)
            }
        }
    }
}

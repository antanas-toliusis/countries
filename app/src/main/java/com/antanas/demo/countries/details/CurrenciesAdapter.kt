package com.antanas.demo.countries.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.ItemCurrencyBinding
import com.antanas.demo.domain.entities.Currency

class CurrenciesAdapter(private val currencies: List<Currency>) : RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_currency, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int = currencies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCurrencyBinding.bind(view)

        fun bind(currency: Currency) {
            with(binding) {
                code.text = currency.code
                name.text = currency.name
            }
        }
    }
}

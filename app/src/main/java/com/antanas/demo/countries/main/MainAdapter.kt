package com.antanas.demo.countries.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.ItemMainAdapterBinding
import com.antanas.demo.domain.entities.CountryEntity
import library.core.extensions.loadSwg

class MainAdapter(
    private val listener: (CountryEntity, View) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    private var data = emptyList<CountryEntity>()

    fun setData(data: List<CountryEntity>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main_adapter, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount(): Int = data.size
}

class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMainAdapterBinding.bind(view)

    fun bind(country: CountryEntity, listener: (CountryEntity, View) -> Unit) =
        with(binding) {
            root.setOnClickListener { listener(country, view) }
            image.loadSwg(country.flagUrl)
            name.text = country.name
        }
}

package com.antanas.demo.countries.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antanas.demo.countries.R
import com.antanas.demo.countries.databinding.ItemMainAdapterBinding

class MainAdapter(
    private val listener: (Any, View) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    private var data = listOf<Any>()

    fun setData(data: List<Any>) {
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

    fun bind(character: Any, listener: (Any, View) -> Unit) =
        with(binding) {
            root.setOnClickListener { listener(character, view) }
            name.text = "test"
        }
}

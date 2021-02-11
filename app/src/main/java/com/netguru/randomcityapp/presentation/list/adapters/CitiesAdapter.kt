package com.netguru.randomcityapp.presentation.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.netguru.domain.models.CityModel
import com.netguru.randomcityapp.databinding.CityListItemBinding

class CitiesAdapter(private val onCityClicked: (CityModel) -> Unit) :
    ListAdapter<CityModel, CitiesAdapter.ViewHolder>(Callback) {

    companion object {
        val Callback = object : DiffUtil.ItemCallback<CityModel>() {
            override fun areItemsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
                return oldItem.created == newItem.created
            }

            override fun areContentsTheSame(
                oldItem: CityModel,
                newItem: CityModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CityListItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: CityListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: CityModel) {
            binding.root.setOnClickListener { onCityClicked(model) }
            binding.model = model
        }
    }
}
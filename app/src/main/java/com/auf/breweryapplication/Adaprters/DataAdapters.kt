package com.auf.breweryapplication.Adaprters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auf.breweryapplication.Models.BrewingInfoData
import com.auf.breweryapplication.databinding.BreweriesContentRvBinding
import java.io.Serializable

class DataAdapters(private var brewlist: ArrayList<BrewingInfoData>) : RecyclerView.Adapter<DataAdapters.BrewDataViewHolder>(), Serializable {
    inner class BrewDataViewHolder(private val binding: BreweriesContentRvBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(itemData: BrewingInfoData){
            binding.companyName.text = itemData[0].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrewDataViewHolder {
        val binding = BreweriesContentRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BrewDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrewDataViewHolder, position: Int) {
        val brewData = brewlist[position]
        holder.bind(brewData)
    }

    override fun getItemCount(): Int {
        return brewlist.size
    }



}

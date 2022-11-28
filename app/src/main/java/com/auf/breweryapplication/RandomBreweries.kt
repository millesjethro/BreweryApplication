package com.auf.breweryapplication

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.auf.breweryapplication.Adaprters.DataAdapters
import com.auf.breweryapplication.Models.BrewingInfoData
import com.auf.breweryapplication.databinding.ActivityRandomBreweriesBinding
import java.util.ArrayList

class RandomBreweries : AppCompatActivity() {
    private lateinit var binding: ActivityRandomBreweriesBinding
    private lateinit var adapter: DataAdapters
    private lateinit var brewingData: ArrayList<BrewingInfoData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomBreweriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DataAdapters(brewingData)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvRandom.layoutManager = layoutManager
        binding.rvRandom.adapter = adapter
    }
}
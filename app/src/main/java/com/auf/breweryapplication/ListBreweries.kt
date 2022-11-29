package com.auf.breweryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.auf.breweryapplication.Adaprters.DataAdapters
import com.auf.breweryapplication.Models.BrewingInfoData
import com.auf.breweryapplication.Services.Helper.Retrofit
import com.auf.breweryapplication.Services.Repository.ListBreweriesAPI
import com.auf.breweryapplication.databinding.ActivityListBreweriesBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class ListBreweries : AppCompatActivity() {
    private lateinit var binding: ActivityListBreweriesBinding
    private lateinit var adapter: DataAdapters
    private lateinit var brewingData: ArrayList<BrewingInfoData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBreweriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        brewingData = arrayListOf()
        adapter = DataAdapters(brewingData, this)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvBrew.layoutManager = layoutManager
        binding.rvBrew.adapter = adapter


    }

    override fun onResume() {
        super.onResume()

        val BrewAPI = Retrofit.getInstance().create(ListBreweriesAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val result = BrewAPI.getListBreweries()
            val brewData = result.body()

            if (brewData != null) {
                brewingData.clear()
                brewingData.addAll(listOf(brewData))
            }
        }
    }
}
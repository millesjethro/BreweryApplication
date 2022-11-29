package com.auf.breweryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.auf.breweryapplication.Adaprters.DataAdapters
import com.auf.breweryapplication.Models.BrewingInfoData
import com.auf.breweryapplication.Services.Helper.Retrofit
import com.auf.breweryapplication.Services.Repository.RandomBreweriesAPI
import com.auf.breweryapplication.databinding.ActivityRandomBreweriesBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class RandomBreweries : AppCompatActivity() {
    private lateinit var binding: ActivityRandomBreweriesBinding
    private lateinit var adapter: DataAdapters
    private lateinit var brewingData: ArrayList<BrewingInfoData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomBreweriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load("https://img.icons8.com/ios/512/ask-question.png")
            .transform(RoundedCorners(25))
            .into(binding.imgBtnRandom);
    }
}
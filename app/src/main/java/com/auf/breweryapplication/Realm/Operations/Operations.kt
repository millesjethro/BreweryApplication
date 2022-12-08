package com.auf.breweryapplication.Realm.Operations

import com.auf.breweryapplication.Models.BrewingInformation
import com.auf.breweryapplication.Realm.Database.BrewRealms
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers

class Operations(private var config: RealmConfiguration) {
    suspend fun InsertBrew(name: String, city: String,Country: String){
        val realm = Realm.getInstance(config)
        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            val Brew = BrewRealms(name = name, city = city, country = Country)
            realmTransaction.insert(Brew)
        }
    }

    suspend fun retrieveBrew(): ArrayList<BrewingInformation>{
        val realm = Realm.getInstance(config)
        val realmResults = arrayListOf<BrewingInformation>()

        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            realmResults.addAll(realmTransaction
                .where(BrewRealms::class.java)
                .findAll()
                .map{
                    mapBrew(it)
                })
        }

        return realmResults
    }

    private fun mapBrew(Brew: BrewRealms): BrewingInformation{
        return BrewingInformation(
            id = Brew.id,
            address_2 = Brew.address2,
            address_3 = Brew.address3,
            brewery_type = Brew.brewerytype,
            city = Brew.city,
            country = Brew.country,
            county_province = Brew.countyProvince,
            created_at = Brew.createdat,
            latitude = Brew.latitude,
            longitude = Brew.longitude,
            name = Brew.name,
            phone = Brew.phone,
            postal_code = Brew.postalcode,
            state = Brew.state,
            street = Brew.street,
            updated_at = Brew.updatedAt,
            website_url = Brew.websiteUrl
        )
    }
}
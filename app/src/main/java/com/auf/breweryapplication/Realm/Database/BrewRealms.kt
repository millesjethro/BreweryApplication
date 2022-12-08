package com.auf.breweryapplication.Realm.Database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId
import java.util.Objects

open class BrewRealms(
    @PrimaryKey
    var id: String = ObjectId().toHexString(),
    @Required
    var address2: String = "",
    var address3: String = "",
    var brewerytype: String = "",
    var city: String = "",
    var country: String = "",
    var countyProvince: String = "",
    var createdat: String = "",
    var latitude: String = "",
    var longitude: String = "",
    var name: String = "",
    var phone: String = "",
    var postalcode: String = "",
    var state: String = "",
    var updatedAt: String = "",
    var websiteUrl: String = "",
    var street: String = ""
    ): RealmObject()

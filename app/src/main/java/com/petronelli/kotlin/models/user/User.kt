package com.petronelli.kotlin.models.user

import io.realm.RealmModel
import java.util.*

/**
 * @author Angelo Petronelli on 21/05/2017.
 */

data class User(
        var id: Int,
        var name: String,
        var surname: String,
        var birthDate: Date,
        var address: String,
        var city: String,
        var zipCode: String,
        var url: String) : RealmModel {

    constructor(id: Int, name: String, url: String) : this(id, name, "", Date(), "", "", "", url)
}

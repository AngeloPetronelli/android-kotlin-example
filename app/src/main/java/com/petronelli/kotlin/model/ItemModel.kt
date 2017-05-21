package com.petronelli.kotlin.model

/**
 * @author Angelo Petronelli on 21/05/2017.
 */

data class ItemModel(private var id: Int, private var name: String, private var url: String) {

    fun getId(): Int {
        return this.id
    }

    fun getName(): String {
        return this.name
    }

    fun getUrl(): String {
        return this.url
    }
}

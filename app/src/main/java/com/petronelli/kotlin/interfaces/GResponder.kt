package com.petronelli.kotlin.interfaces

/**
 * @author Angelo Petronelli on 21/05/2017.
 */
interface GResponder<in T> {
    fun onResponse(t: T)
}

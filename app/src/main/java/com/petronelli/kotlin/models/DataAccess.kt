package com.petronelli.kotlin.models

import io.reactivex.Observable

/**
 * @author Angelo Petronelli on 11/06/2017.
 */

interface DataAccess<T> {

    fun read(id: Int): Observable<T>

    fun read(): Observable<Collection<T>>

    fun write(model: T): Observable<T>

    fun write(list: Collection<T>): Observable<Collection<T>>
}
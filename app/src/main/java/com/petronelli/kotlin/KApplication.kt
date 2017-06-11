package com.petronelli.kotlin

import android.app.Application
import io.realm.Realm

/**
 * @author Angelo Petronelli on 31/05/2017.
 */
class KApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
    }
}
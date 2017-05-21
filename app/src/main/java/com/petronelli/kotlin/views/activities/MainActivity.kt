package com.petronelli.kotlin.views.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.petronelli.kotlin.R
import com.petronelli.kotlin.views.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .commit()
    }
}

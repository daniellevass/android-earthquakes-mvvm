package com.daniellevass.earthquakesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.daniellevass.earthquakesmvvm.viewmodel.MainViewModel
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getEarthquakes().observe(this, Observer { earthquakes ->
            Log.d("DANIELLE", "got ${earthquakes.size} earthquakes")
        })

    }
}
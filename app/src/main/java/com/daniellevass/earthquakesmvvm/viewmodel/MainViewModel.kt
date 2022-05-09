package com.daniellevass.earthquakesmvvm.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.daniellevass.earthquakesmvvm.data.EarthquakeRepository
import com.daniellevass.earthquakesmvvm.data.EarthquakeRepositoryImpl
import com.daniellevass.earthquakesmvvm.Earthquake

class MainViewModel (private val repository: EarthquakeRepository = EarthquakeRepositoryImpl()) : ViewModel() {

    private val allEarthquakes = MediatorLiveData<List<Earthquake>>()

    init {
        getAllEarthquakes()
    }

    fun getEarthquakes() = allEarthquakes

    private fun getAllEarthquakes() {
        allEarthquakes.addSource(repository.getAllRecentEarthquakes()) { earthquakes ->
            allEarthquakes.postValue(earthquakes)
        }
    }

}
package com.daniellevass.earthquakesmvvm.data

import androidx.lifecycle.LiveData
import com.daniellevass.earthquakesmvvm.Earthquake

interface EarthquakeRepository {

    fun getAllRecentEarthquakes(): LiveData<List<Earthquake>>
}
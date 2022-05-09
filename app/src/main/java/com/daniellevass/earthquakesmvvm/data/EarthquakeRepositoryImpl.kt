package com.daniellevass.earthquakesmvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.daniellevass.earthquakesmvvm.Earthquake
import com.daniellevass.earthquakesmvvm.data.model.EarthquakeResponse
import com.daniellevass.earthquakesmvvm.data.model.PropertyResponse
import com.daniellevass.earthquakesmvvm.data.net.EarthquakeClient
import com.daniellevass.earthquakesmvvm.data.net.EarthquakeMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EarthquakeRepositoryImpl : EarthquakeRepository{

    private val earthquakeClient = EarthquakeClient()

    override fun getAllRecentEarthquakes(): LiveData<List<Earthquake>> {
        val data = MutableLiveData<List<Earthquake>>()

        earthquakeClient
            .getAllTodayEarthquakes()
            .enqueue(object : Callback<EarthquakeResponse> {
            override fun onFailure(call: Call<EarthquakeResponse>, t: Throwable) {
                data.value = emptyList()
            }

            override fun onResponse(call: Call<EarthquakeResponse>, response: Response<EarthquakeResponse>) {

                val processedEarthquakes = arrayListOf<Earthquake>()

                response.body()?.let { earthquakeResponse ->
                    processedEarthquakes.addAll(EarthquakeMapper.map(earthquakeResponse))
                }

                data.value = processedEarthquakes.toList()
            }
        })
        return data
    }

}
package com.daniellevass.earthquakesmvvm.data.net

import com.daniellevass.earthquakesmvvm.data.model.EarthquakeResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EarthquakeClient {

    private val earthquakeApi: EarthquakeApi

    companion object {
        private const val ENDPOINT = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/"
    }

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        earthquakeApi = retrofit.create(EarthquakeApi::class.java)
    }

    fun getAllTodayEarthquakes(): Call<EarthquakeResponse> {
        return earthquakeApi.getAllTodayEarthquakes()
    }

}
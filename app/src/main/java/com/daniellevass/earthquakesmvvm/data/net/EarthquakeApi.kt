package com.daniellevass.earthquakesmvvm.data.net

import com.daniellevass.earthquakesmvvm.data.model.EarthquakeResponse

import retrofit2.http.GET
import retrofit2.Call

interface EarthquakeApi {
    @GET("all_day.geojson")
    fun getAllTodayEarthquakes(): Call<EarthquakeResponse>
}
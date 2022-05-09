package com.daniellevass.earthquakesmvvm.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EarthquakeResponse (
    @SerializedName("features")
    @Expose
    val earthquakes: List<FeatureResponse>? = null
)

class FeatureResponse {
    @SerializedName("properties")
    @Expose
    val property: PropertyResponse? = null
}

class PropertyResponse {
    @SerializedName("place")
    @Expose
    val place: String? = null

    @SerializedName("mag")
    @Expose
    val mag = 0f

    @SerializedName("time")
    @Expose
    val time: Long = 0
}
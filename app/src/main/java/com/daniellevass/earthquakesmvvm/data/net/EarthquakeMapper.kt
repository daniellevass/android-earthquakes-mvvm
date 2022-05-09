package com.daniellevass.earthquakesmvvm.data.net

import com.daniellevass.earthquakesmvvm.Earthquake
import com.daniellevass.earthquakesmvvm.data.model.EarthquakeResponse
import com.daniellevass.earthquakesmvvm.data.model.PropertyResponse

class EarthquakeMapper {

    companion object {
        fun map(earthquakeResponse: EarthquakeResponse) : List<Earthquake> {
            val processedEarthquakes = arrayListOf<Earthquake>()
            if (!earthquakeResponse.earthquakes.isNullOrEmpty()) {
                earthquakeResponse.earthquakes.map { feature ->
                    feature.property?.let { property ->
                        val earthquake = mapProperty(property)
                        earthquake?.let {
                            processedEarthquakes.add(earthquake)
                        }
                    }

                }
            }
            return processedEarthquakes
        }

        private fun mapProperty(propertyResponse: PropertyResponse) : Earthquake? {
            if (propertyResponse.place == null) {
                return null
            }

            return Earthquake(
                location = propertyResponse.place,
                magnitude = propertyResponse.mag,
                time = propertyResponse.time
            )
        }

    }



}
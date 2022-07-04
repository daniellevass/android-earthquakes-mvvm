package com.daniellevass.earthquakesmvvm.data.net

import com.daniellevass.earthquakesmvvm.data.model.EarthquakeResponse
import junit.framework.Assert.assertEquals
import org.junit.Test

class EarthquakeMapperTest {

    @Test
    fun map_nullEarthquakes() {
        val response = EarthquakeResponse(earthquakes = null)
        val actual = EarthquakeMapper.map(response)
        assertEquals(0, actual.size)
    }

}
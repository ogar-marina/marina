package com.example.pogoda

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {
    @GET("weather.json")
    fun getWeather(): Call<Weather>
}

data class Weather(
    @SerializedName("yesterday")
    val yesterday: String,
    @SerializedName("today")
    val today: String,
    @SerializedName("tomorrow")
    val tomorrow: String
)

package com.example.pogoda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class State(
    val yesterdayTemp: Int,
    val todayTemp: Int,
    val tomorrowTemp: Int,
    val isLoading: Boolean
)

class MainViewModel : ViewModel() {
    val state = MutableLiveData<State>()

    private val api: WeatherApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://raw.githubusercontent.com/ogar-marina/marina/master/pogoda/")
        .build()
        .create(WeatherApi::class.java)

    fun fetchWeather() {
        state.value = state.value?.copy(isLoading = true)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = api.getWeather().execute()

                if (response.isSuccessful) {
                    val weather = response.body() ?: return@withContext
                    state.value = State(
                        yesterdayTemp = weather.yesterday.toInt(),
                        todayTemp = weather.today.toInt(),
                        tomorrowTemp = weather.tomorrow.toInt(),
                        isLoading = false
                    )
                } else {
                    println("Request failed")
                }
            }
        }
    }

}

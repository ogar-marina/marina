package com.skillbox.multithreading.networking

import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.util.concurrent.TimeUnit

object Network {

    const val MOVIE_API_KEY = "582f2ce2"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .readTimeout(30_000, TimeUnit.MILLISECONDS)
        .writeTimeout(30_000, TimeUnit.MILLISECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("http://www.omdbapi.com")

        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMovieById(movieId: String): Movie? {
        return try {
            api().getMovieById(movieId, MOVIE_API_KEY).execute().body()
        } catch (e: IOException) {
            null
        }
    }

    fun api(): MovieApi {
        return retrofit.create()
    }
}
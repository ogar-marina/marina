package com.example.a01_generics

import kotlin.random.Random

sealed class Result <out T,R> {
    data class Success<T, R>(val success: T) : Result<T, R>() {}
    data class Error<T, R>(val mistake: R) : Result<T, R>() {}

}
fun returnResult(): Result <Int, String>{
    return if (Random.nextBoolean()){ Result.Success(success = 20)}
    else Result.Error(mistake = "Error")
}



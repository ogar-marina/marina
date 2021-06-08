package com.example.homework34

fun main() {
    print("Введите количество чисел: ")
    val n = readLine()?.toIntOrNull()

    var accum = 0
    var sum = 0
    for (i in 1..n!!) {
        print("Введите чило: ")
        var z: Int = readLine()?.toIntOrNull() ?: continue
        if (z > 0) accum += 1
        sum += z
    }
    println("Количество положительных чисел: $accum")
    println("Сумма всех введенных чисел: $sum")

}
package com.example.homework34

fun main() {
    print("Введите количество чисел: ")
    val n = readLine()?.toIntOrNull()

    var accum = 0
    var sum = 0
    var mainNumber = 0
    if (n != null) {
        while (mainNumber < n){
            print("Введите чило: ")
            val z: Int = readLine()?.toIntOrNull() ?: continue
            if (z > 0) accum += 1
            sum += z
            if (z!= null){
                mainNumber++
            }
        }
    }
    println("Количество положительных чисел: $accum")
    println("Сумма всех введенных чисел: $sum")
}
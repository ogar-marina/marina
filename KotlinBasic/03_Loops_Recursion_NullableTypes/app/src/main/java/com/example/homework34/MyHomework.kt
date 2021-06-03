package com.example.homework34

fun main() {
    print("Введите количество чисел: ")
    val n = readLine()?.toIntOrNull() ?:return
     if (n!=null) {
         println(valueNumbers(n))
     }
         else {
             println("Это не число")
     }
    var accum = 0
    var sum= 0
    for (i in 1..n){
        print("Введите чило: ")
        var z: Int = readLine()?.toIntOrNull() ?:return
        if (z>0) accum +=1
        sum += z
    }
    println("Количество положительных чисел: $accum")
    println("Сумма всех введенных чисел: $sum")
}

fun valueNumbers(n: Int) {
  var mainNumber = 0
    while (mainNumber < n) {
        println("Введите число: ")
        val numberString = readLine()?.toIntOrNull()?:continue
        if (numberString != null){
            mainNumber ++
        }
    }
}

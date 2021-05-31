package com.example.homework2

fun main() {
    val solutionSum = solveEquation(a = 1, b = 10, c = -24)
    println(solutionSum)

}

fun solveEquation(a: Int, b:Int, c: Int): Double? {
//Рассчитывается дискриминант:
    val d: Double = (b*b)-(4*a*c). toDouble()
    return if (d>0) {
//Рассчитываются корни:
        val x1 = ((-b) - kotlin.math.sqrt(d)) / (2 * a).toDouble()
        val x2 = ((-b) + kotlin.math.sqrt(d)) / (2 * a).toDouble()
        println(x1)
        println(x2)
        val solutionSum: Double = x1 + x2
        solutionSum
    }
    else {
        null
    }


}


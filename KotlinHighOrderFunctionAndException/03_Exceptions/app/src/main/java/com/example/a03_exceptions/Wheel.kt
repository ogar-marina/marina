package com.example.a03_exceptions

class Wheel {
    private var pressure: Double = 0.0
    private set
    fun setPressure(value:Double){
        if (value < 0 || value > 10){
            throw IncorrectPressure()
        }
        else {
            pressure = value
            check(pressure)
        }
    }
    fun check(value: Double){
        if (value < 1.6 && value >= 0) throw TooLowPressure()
        if (value > 2.5 && value <= 10) throw TooHighPressure()
        if (value in 1.6..2.5) println("Процедура удалась. Эксплуатация возможна")
    }

     class TooHighPressure(): Exception(){
         override val message: String?
         get()= "Процедура удалась. Эксплуатация невозможна — давление превышает нормальное"
     }

    class TooLowPressure(): Exception(){
        override val message: String?
        get()= "Процедура удалась. Эксплуатация невозможна — давление ниже нормального"
    }

    class IncorrectPressure(): Exception() {
        override val message: String?
            get() = "Процедура не удалась"
    }
}
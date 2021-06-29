package com.example.classesandinheritance

open class Room() {
    
    private val area: Double = 50.0
    protected open val title: String = "Обычная комната"

    fun getDescription():String{
        return "Комната: $title имеет площадь $area кв.м"
        }
    init {
        println("New room is initialized")
    }
}
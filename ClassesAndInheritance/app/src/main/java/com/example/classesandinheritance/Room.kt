package com.example.classesandinheritance

open class Room( area: Double) {

    private val area: Double = area
    protected open val title: String = "Обычная комната"

    fun getDescription():String{
        return "Комната: $title имеет площадь $area кв.м"
        }
    init {
        println("New room is initialized")
    }
}
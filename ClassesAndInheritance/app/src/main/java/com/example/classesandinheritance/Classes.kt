package com.example.classesandinheritance

fun main() = listOf(
    Room(area = 50.0),
    Bedroom(area = 20.0),
    LivingRoom(area = 27.5),
    Bathroom(area = 15.2),
    ChildRoom(area = 22.4),
    FreeRoom(area = 30.0)

).forEach {
    println(it.getDescription())
}
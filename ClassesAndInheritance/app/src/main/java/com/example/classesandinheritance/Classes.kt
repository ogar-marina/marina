package com.example.classesandinheritance

fun main() = listOf(
    Room(area = 50.0),
    Bedroom(area=20.0),
    LivingRoom(area=25.5),
    Bathroom(area=15.2),
    ChildRoom(area=22.4),
    FreeRoom()

).forEach{
    println(it.getDescription())}
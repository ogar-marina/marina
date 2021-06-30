package com.example.classesandinheritance

fun main() = listOf(
    Room(area = 50.0),
    Bedroom(),
    LivingRoom(),
    Bathroom(),
    ChildRoom(),
    FreeRoom()

).forEach{
    println(it.getDescription())}
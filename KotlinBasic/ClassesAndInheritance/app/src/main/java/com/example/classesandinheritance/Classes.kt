package com.example.classesandinheritance

fun main(){
    listOf(
        Room(),
        Bedroom(),
        LivingRoom(),
        Bathroom(),
        ChildRoom(),
        FreeRoom()

        ).forEach{
        println(it.getDescription())}
}
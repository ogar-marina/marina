package com.example.homework4

fun main(){
    val array = arrayOf("Петр", "Александр", "Василий")

    for (user in array){
        println(user)
    }
    array.forEach { println(it) }
    array.forEachIndexed { index, user -> println("Index = $index, element = $user")  }

    val firstElement = array[0]
    val lastElement = array[array.lastIndex]
    
}
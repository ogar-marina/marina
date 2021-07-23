package com.example.a01_generics

fun main(){
    val newList = listOf(10.00, 15.5, 20.00, 25.5, 3,2 )
    val newList2 = listOf(11, 13, 15, 16)
    println(genericFun(newList))
    println(genericFun(newList2))

    val queue = Queue<String>()
    queue.enqueue(item = "Marina")
    queue.enqueue(item = "Misha")
    queue.enqueue(item = "Alexey")
    queue.dequeue()
    println(queue)

    println(returnResult())
}

fun <T:Number> genericFun (list: List<T>): List<T> {
    return list.filter {it.toDouble() %2 == 0.0}
}
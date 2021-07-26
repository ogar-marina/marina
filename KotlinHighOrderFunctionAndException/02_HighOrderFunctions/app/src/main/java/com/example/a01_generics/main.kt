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
    queue.enqueue(item = "Mariya")
    queue.enqueue(item = "Dmitriy")
    queue.enqueue(item = "Marina")
    queue.dequeue()
    println(queue)

    val result = queue.filter {it !=("Marina")}
    println(result)

    val result2 = queue.filter2(element = ("M"))
    println(result2)
   }

fun <T:Number> genericFun (list: List<T>): List<T> {
    return list.filter {it.toDouble() %2 == 0.0}
}
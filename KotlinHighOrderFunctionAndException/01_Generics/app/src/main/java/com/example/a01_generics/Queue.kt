package com.example.a01_generics

class Queue<T> {
   private var objectListQueue: MutableList<T> = mutableListOf()

    fun enqueue(item: T){
        objectListQueue.add(item)
    }
    fun dequeue(): T? {
        return objectListQueue.removeFirstOrNull()
        }
}
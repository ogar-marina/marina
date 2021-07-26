 package com.example.a01_generics

class Queue<T> {
    private var objectListQueue: MutableList<T> = mutableListOf()

    fun enqueue(item: T) {
        objectListQueue.add(item)
    }

    fun dequeue(): T? {
        return objectListQueue.removeFirstOrNull()
    }
    override fun toString():String {
        return "Queue (objectListQueue = $objectListQueue)"
    }

    fun filter (predicate: (T) -> Boolean) : Queue<T> {
        var newQueue = Queue<T>()
        for (element in objectListQueue){
            if (predicate(element)) newQueue.enqueue(element)
        }
        return newQueue
    }

    fun filter2 (element: String): Boolean = element.startsWith("M")

}



package com.example.basemethods

fun main(){
    val person1 = Person(height = 158, weight = 48, name= "Marina")
    val person2 = Person(height = 158, weight = 48, name= "Marina")

    val people = hashSetOf<Person>(
        person1,
        person2,
        Person(height=174, weight=65, name="Misha")
        )

    println("Количество персон в сете: ${people.size}")
    people.forEach{
        it.buyPet()
    }

    people.forEach{
        println(it)
    }


}
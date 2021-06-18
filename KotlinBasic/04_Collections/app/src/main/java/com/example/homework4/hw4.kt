package com.example.homework4

fun main(){
    print("Введите количество номеров: ")
    val n:Int= readLine()?.toIntOrNull()?:return
    val s = numberTel(n)
    println("$s")
}

fun numberTel(n: Int): MutableList<String> {

    val newNumber = mutableListOf<String>()
    for (i in 1..n) {
        print("Введите номер телефона: ")
        val t = readLine()?.toString()?.let { newNumber.add(it) }
    }

    val filteredList = newNumber.filter {it.startsWith(prefix = "+7")}
    println(filteredList)

    val sizeNew = newNumber.size
    println(sizeNew)

    val sumBy= newNumber.sumBy { it.length }
    println(sumBy)

    val phoneBook = mutableMapOf<String,String>()
    for (t in newNumber) {
        print("Введите имя человека с номером телефона $t: ")
        val p = (readLine()?.toString()?:0)
        phoneBook[t]= p.toString()
    }


    for(entry in phoneBook) {
        println("Человек: ${phoneBook[entry.key]}. Номер телефона: ${phoneBook[entry.value]}")
    }
    return newNumber
}
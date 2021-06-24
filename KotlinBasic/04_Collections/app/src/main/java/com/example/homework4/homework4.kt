package com.example.homework4

fun main(){
    print("Введите количество номеров: ")
    val n:Int= readLine()?.toIntOrNull()?:return
    val s = numberTel(n)
    println("$s")

    val filteredList = s.filter {it.startsWith(prefix = "+7")}
    println(filteredList)

    val listToSet = s.toSet()
    println("Количество уникальных номеров: ${listToSet.size}")

    val lengthSet= listToSet.sumBy { it.length }
    println("Сумма: $lengthSet")

    val phoneBook = mutableMapOf<String,String>()
    for (t in s) {
        print("Введите имя человека с номером телефона $t: ")
        val p = (readLine()?.toString()?:0)
        phoneBook[t]= p.toString()
    }

    for(entry in phoneBook) {
        println("Человек: ${phoneBook[entry.key]}. Номер телефона: ${phoneBook[entry.value]}")
    }
}

fun numberTel(n: Int): MutableList<String> {

    val newNumber = mutableListOf<String>()
    for (i in 1..n) {
        print("Введите номер телефона: ")
        val t = readLine()?.toString()?.let { newNumber.add(it) }
    }
    return newNumber
}
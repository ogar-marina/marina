package com.example.homework4

fun main(){
    print("Введите количество номеров: ")
    val n:Int= readLine()?.toIntOrNull()?:return
    val s = numberTel(n)
    println("$s")
}

fun numberTel(n: Int) {

    val newNumber = mutableListOf<String>()
    for (i in 1..n){
        print("Введите номер телефона: ")
        val t = newNumber.add(readLine()?.toString()?:0.toString())
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
        val p = (readLine()?.toString()?:0.toString())
        phoneBook[t]= p
    }


    for(entry in phoneBook) {
        println("Человек: ${phoneBook[entry.key]}. Номер телефона: ${phoneBook[entry.value]}")
    }
    }
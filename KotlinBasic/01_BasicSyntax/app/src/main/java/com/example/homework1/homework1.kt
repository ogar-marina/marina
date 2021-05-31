package com.example.homework1

fun main() {
    val firstName: String = "Марина"
    println(firstName)
    val lastName: String = "Огарь"
    println(lastName)

    var height: Int = 156
    println(height)

    var weight = 48.5F
    println(weight)

    var isChild: Boolean = ((height < 150) || (weight < 40))
    println(isChild)

    var info: String = "Информация обо мне: $firstName $lastName; $height; $weight; $isChild. "
    println(info)

    height = 140
    info = "Информация обо мне: $firstName $lastName; $height; $weight; $isChild. "
    println(info)

    weight = 20F
    isChild = ((height < 150) || (weight < 40))
    println(isChild)


}
fun main(){
    val firstName: String = "Марина"
    println(firstName)
    val lastName: String = "Огарь"
    println(lastName)

    val height: Int = 156
    val height2: String = "см"
    val myHeight: String = "Мой рост: $height $height2"
    println(myHeight)

    val weight = 48.5F
    val weight2: String = "кг"
    val myWeight: String = "Мой вес: $weight $weight2"
    println(myWeight)

    val isChild: Any = if((height > 150) && (weight>40))
        "Взрослый" else
        "Ребенок"
    val me: String = "Мой статус: $isChild"
    println(me)

val info: String = "Информация обо мне: $firstName $lastName; $myHeight; $myWeight; $me. "
    println(info)


}
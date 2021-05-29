fun main(){
    val firstName: String = "Марина"
    println(firstName)
    val lastName: String = "Огарь"
    println(lastName)

    var height: Int = 156
    println(height)

    val weight = 48.5F
    println(weight)

    var isChild: Boolean = ((height<150)||(weight<40))
        println(isChild)

var info: String = "Информация обо мне: $firstName $lastName; $height; $weight; $isChild. "
    println(info)

 height = 168
    info= "Информация обо мне: $firstName $lastName; $height; $weight; $isChild. "
    println(info)

    isChild= ((height<160)||(weight<50))

    info= "Информация обо мне: $firstName $lastName; $height; $weight; $isChild. "
    println(info)
}
package com.example.classesandinheritance

class FreeRoom (area:Double=26.2): Room(area) {
override var title: String = "Свободная комната"

    constructor(title: String) : this()
}
package com.example.classesandinheritance

class FreeRoom(title1: String = "Free room", area: Double) : Room(area) {
    override var title: String = title1
}
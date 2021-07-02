package com.example.classesandinheritance

class FreeRoom ( title1: String = "Свободная комната", area:Double):Room(area) {
           override var title: String = title1
   }
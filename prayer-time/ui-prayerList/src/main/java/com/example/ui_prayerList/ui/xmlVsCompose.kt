package com.example.ui_prayerList.ui

data class dataClass(val name:String="csc")
class dataClass2(val name:String="csc")


fun main() {
    //

    val d = dataClass()
    val d3 = dataClass()
    d.name
    val d2 = dataClass2()
    val d4 = dataClass2()
    d2.name

    println(d == d3) // prints "true"
    println(d2 == d4) // prints "false"



}
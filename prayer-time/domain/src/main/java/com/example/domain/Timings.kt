package com.example.domain

data class Timings(
    val Asr: String="",
    val Dhuhr: String="",
    val Fajr: String="",
    val Firstthird: String="",
    val Imsak: String="",
    val Isha: String="",
    val Lastthird: String="",
    val Maghrib: String="",
    val Midnight: String="",
    val Sunrise: String="",
    val Sunset: String=""
)

fun Timings.toMap(): Map<String, String> {
    val map = mutableMapOf<String, String>()
    map["Fajr"] = this.Fajr
    map["Sunrise"] = this.Sunrise
    map["Dhuhr"] = this.Dhuhr
    map["Asr"] = this.Asr
    map["Maghrib"] = this.Maghrib
    map["Isha"] = this.Isha
    return map
}
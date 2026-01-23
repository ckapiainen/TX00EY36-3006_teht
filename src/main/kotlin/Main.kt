package app

import app.lab02.Kahvinkeitin

fun main() {
    val k = Kahvinkeitin()
    println(k)
    k.taytaVesiSailio()
    k.taytaKahviSailio()
    println(k)
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    println("tee espresso: ${k.teeEspresso()}")
    println(k)
    k.painaOnOffNappia()
    println("tee tavallinen kahvi: ${k.teeTavallinenKahvi()}")
    println(k)
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println(k)
    }
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    k.taytaVesiSailio()
    println(k)
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println(k)
    }
}
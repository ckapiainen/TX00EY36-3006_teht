package app.lab01

open class Human(val name: String, var age: Int) {
    fun getOlder() {
        age += 1
    }
}
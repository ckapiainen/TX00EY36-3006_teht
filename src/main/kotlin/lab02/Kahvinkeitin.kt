package app.lab02

class Kahvinkeitin(
    private val vesiKapasiteetti: Int = 300,
    private val kahviKapasiteetti: Int = 100
) {
    var päällä: Boolean = false

    var vesiSailio: Int = 0
        private set

    var kahviSailio: Int = 0
        private set

    val espressoja: Int
        get() =   if (vesiSailio / 30 < kahviSailio / 16) vesiSailio / 30 else kahviSailio / 16


    val tavallisia: Int
        get() = if (vesiSailio / 200 < kahviSailio / 15) vesiSailio / 200 else kahviSailio / 15

    fun painaOnOffNappia() {
        päällä = !päällä
    }

    fun taytaKahviSailio() {
        kahviSailio = kahviKapasiteetti
    }

    fun taytaVesiSailio() {
        vesiSailio = vesiKapasiteetti
    }

    fun teeEspresso(): Boolean {
        if (vesiSailio < 30 || kahviSailio < 16 || !päällä) return false
        vesiSailio -= 30
        kahviSailio -= 16
        return true
    }

    fun teeTavallinenKahvi(): Boolean {
        if (vesiSailio < 200 || kahviSailio < 15 || !päällä) return false
        vesiSailio -= 200
        kahviSailio -= 15
        return true
    }

    override fun toString(): String {
        return "Keitin: $vesiSailio/$vesiKapasiteetti vettä, $kahviSailio/$kahviKapasiteetti kahvia, päällä=$päällä"
    }
}
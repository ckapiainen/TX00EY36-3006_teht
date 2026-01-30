package app.lab03

class Fraction(
    private val numerator: Int, private val denominator: Int,
    private val sign: Int = 1
) : Comparable<Fraction> {

    fun add(other: Fraction): Fraction {
        val commonDen = lcm(this.denominator, other.denominator)
        val newNum1 = this.sign * this.numerator * (commonDen /
                this.denominator)
        val newNum2 = other.sign * other.numerator * (commonDen /
                other.denominator)
        val resultNum = newNum1 + newNum2

        val resultSign = if (resultNum >= 0) 1 else -1
        return Fraction(kotlin.math.abs(resultNum), commonDen, resultSign)
    }


    fun subtract(other: Fraction): Fraction {
        val commonDen = lcm(this.denominator, other.denominator)
        val newNum1 = this.sign * this.numerator * (commonDen /
                this.denominator)
        val newNum2 = other.sign * other.numerator * (commonDen /
                other.denominator)
        val resultNum = newNum1 - newNum2

        val resultSign = if (resultNum >= 0) 1 else -1
        return Fraction(kotlin.math.abs(resultNum), commonDen, resultSign)
    }


    fun negate(): Fraction = Fraction(numerator, denominator, -sign)

    operator fun plus(other: Fraction): Fraction = add(other)

    operator fun unaryPlus(): Fraction = Fraction(numerator, denominator, sign)

    operator fun minus(other: Fraction): Fraction = add(other.unaryMinus())

    operator fun unaryMinus(): Fraction = Fraction(numerator, denominator, -sign)

    operator fun times(other: Fraction): Fraction = Fraction(numerator * other.numerator, denominator * other.denominator)

    fun mult(other: Fraction): Fraction = times(other)

    operator fun div(other: Fraction): Fraction = Fraction(numerator * other.denominator, denominator * other.numerator)

    override fun compareTo(other: Fraction): Int {
        val left = this.numerator * other.denominator * this.sign
        val right = other.numerator * this.denominator * other.sign
        return when {
            left > right -> 1
            left < right -> -1
            else -> 0
        }
    }

    // euclidean algorithm
    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private fun lcm(a: Int, b: Int): Int = a / gcd(a, b) * b

    override fun toString(): String {
        val gcd = gcd(numerator, denominator)
        val sign = if (sign > 0) "" else "-"
        return "$sign${numerator / gcd}/${denominator / gcd}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Fraction) return false
        return this.compareTo(other) == 0
    }

    override fun hashCode(): Int {
        val gcd = gcd(numerator, denominator)
        return 31 * (numerator / gcd) + (denominator / gcd) * sign
    }
}
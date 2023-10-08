import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    repeat(N) {
        val num = br.readLine().split(" ").map { it.toBigInteger() }
        var A = BigInteger.ZERO
        var B = BigInteger.ZERO
        if (num[0] < num[1]) {
            A = num[0]
            B = num[1]
        }
        else {
            A = num[1]
            B = num[0]
        }
        var div = BigInteger("2")
        var lcm = BigInteger.ONE
        while (true) {
            if (A == BigInteger.ONE || A < div) break
            if (A % div == BigInteger.ZERO && B % div == BigInteger.ZERO) {
                A /= div
                B /= div
                lcm *= div
                div = BigInteger("2")
            }
            else div++
        }
        println(lcm * A * B)
    }
}
import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val line = br.readLine().split(" ").map { it.toInt() }
        var sum: BigInteger = BigInteger.ZERO
        for (i in 1..line[0]) {
            for (j in i+1..line[0]) {
                var first = line[i]
                var second = line[j]
                // gcd 구하기
                var div = 2
                var gcd = 1
                while (true) {
                    if (first < div || second < div || first == 1 || second == 1) break
                    if (first % div == 0 && second % div == 0) {
                        first /= div
                        second /= div
                        gcd *= div
                        div = 2
                    }
                    else {
                        div++
                    }
                }
                sum += gcd.toBigInteger()
            }
        }
        println(sum)
    }
}
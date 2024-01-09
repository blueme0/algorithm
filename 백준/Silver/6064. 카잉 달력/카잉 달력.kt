fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }
        val last = lcm(m, n)
        var i = 0
        var result = -1
        while (true) {
            val now = i * m + x
            if (now > last) break
            if ((now - y) % n == 0) {
                result = now
                break
            }
            i++
        }
        sb.appendLine(result)
        /**
         * a * 10 + 3 == b * 12 + 9 == result
         * a * m + x == b * n + y
         * a * m - b * n = y - x
         * 만약에
         * 최소 공배수 -> last 카잉 달력
         */
    }
    print(sb)
}

fun lcm(a: Int, b: Int) = a * b / gcd(a, b)

fun gcd(a: Int, b: Int): Int {
    return if (a < b) {
        if (a == 0) b else gcd(a, b % a)
    }
    else {
        if (b == 0) a else gcd(b, a % b)
    }
}
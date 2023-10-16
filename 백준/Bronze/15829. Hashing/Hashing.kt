fun main() {
    val br = System.`in`.bufferedReader()
    val L = br.readLine().toInt()
    val num = br.readLine()
    val M: Int = 1234567891

    var h: Long = 0
    for (i in 0 until num.length) {
        var now: Long = 1
        for (j in 1 ..i) {
            now *= 31
            if (now > M) now %= M
        }
        h += (num[i].code - 96).toLong() * now
        if (h > M) {
            h %= M
        }
    }

    print(h)
}
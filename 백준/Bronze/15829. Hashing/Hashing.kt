fun main() {
    val br = System.`in`.bufferedReader()
    val L = br.readLine().toInt()
    val num = br.readLine()
    val M: Int = 1234567891

    var h: Long = 0
    for (i in 0 until num.length) {
        h += (num[i].code - 96) * Math.pow(31.0, i.toDouble()).toLong() % M
        h %= M
    }

    print(h)
}
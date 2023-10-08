fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val X = br.readLine().toInt()
    var sum = 0L
    var count = 0
    for (num in arr) {
        if (gcd(num, X) == 1) {
            sum += num.toLong()
            count++
        }
    }
    println("%.6f".format(sum.toDouble()/count.toDouble()))
}

fun gcd(p0: Int, p1: Int): Int {
    // a > b 여야 함!
    var a = p0
    var b = p1
    if (p0 < p1) {
        a = p1
        b = p0
    }

    while (true) {
        var r = a % b
        if (r == 0) return b

        a = b
        b = r
    }

}
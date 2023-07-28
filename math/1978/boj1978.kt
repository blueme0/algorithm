import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    var cnt = 0
    var index = 0

    while (index < N) {
        val str = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until str.size) {
            index++

            if (isPrime(str[j])) cnt++
        }
    }
    println(cnt)
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2 until num) {
        if (num % i == 0) return false
    }
    return true
}
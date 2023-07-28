fun main() {
    val br = System.`in`.bufferedReader()
    val M = br.readLine().toInt()
    val N = br.readLine().toInt()
    var min = 0
    var sum = 0

    for (i in M..N) {
        if (isPrime(i)) {
            if (min == 0) min = i
            sum += i
        }
    }
    if (sum == 0) print(-1)
    else print("$sum\n$min")
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2 until num) {
        if (num % i == 0) return false
    }
    return true
}
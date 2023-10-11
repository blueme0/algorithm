
fun main() {
    val br = System.`in`.bufferedReader()
    val (A, B, C) = br.readLine().split(" ").map { it.toInt() }
    println(pow(A, B, C))
}

fun pow(a: Int, b: Int, mod: Int): Long {
    if (b == 0) return 1
    val n = pow(a, b /2, mod)
    if (b % 2 == 0)
        return n * n % mod
    else
        return (n * n % mod) * a % mod
}
fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    if (K == 0) println(1)
    else println(fact(N, K) / fact(K, K))
}

fun fact(N: Int, K: Int): Int {
    var result = 1
    var newN = N
    repeat(K){
        result *= newN
        newN--
    }
    return result
}
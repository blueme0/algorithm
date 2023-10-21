fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val coins = mutableListOf<Int>()
    repeat(N) {
        coins.add(br.readLine().toInt())
    }
    var count = 0
    coins.sort()
    var rest = K
    for (i in N-1 downTo 0) {
        if (rest == 0) break
        count += rest / coins[i]
        rest %= coins[i]
    }
    println(count)
}
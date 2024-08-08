import java.io.BufferedReader
import java.io.InputStreamReader

val dp = Array<Int>(10001) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val coins = Array(n) { 0 }
    for (i in 0 until n) coins[i] = br.readLine().toInt()

    dp[0] = 1
    for (i in 0 until n) {
        for (j in coins[i]..k) {
            dp[j] += dp[j - coins[i]]
        }
    }
    print(dp[k])
}
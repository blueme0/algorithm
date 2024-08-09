import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1) { 10_001 }
    dp[0] = 0
    
    repeat(n) {
        val coin = br.readLine().toInt()
        for (i in coin..k) {
            dp[i] = Math.min(dp[i], dp[i - coin] + 1)
        }
    }
    
    if (dp[k] == 10_001) print(-1) else print(dp[k])
}
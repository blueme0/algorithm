import java.io.BufferedReader
import java.io.InputStreamReader

const val MOD = 1_000_000_000

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val half = (N + 1) / 2

    val dp = Array(half + 1) { 0 }
    dp[0] = 1
    dp[1] = 2
    for (i in 2..half) {
        dp[i] += (dp[i - 1] + dp[(i - 1) / 2]) % MOD
        dp[i] %= MOD
        if (i % 2 == 0) {
            dp[i] += dp[i / 4]
            dp[i] %= MOD
        }
    }

    print(dp[N / 2])
}
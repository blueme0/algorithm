import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    if (N % 2 != 0) {
        print(0)
        return
    }

    val dp = IntArray(16) { 0 }

    dp[1] = 3
    for (i in 2..N / 2) {
        dp[i] += dp[i - 1] * 3
        for (j in 2..i) {
            dp[i] += dp[i - j] * 2
        }
        dp[i] += 2
    }

    print(dp[N / 2])
}
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val sum = IntArray(N + 1) { 0 }

    for (i in 1..N) {
        sum[i] = sum[i - 1] + br.readLine().toInt()
    }

    val dp = Array(N + 1) { Array(M + 1) { 0 } }
    for (i in 1..M) dp[0][i] = -3276800

    for (i in 1..N) {
        for (j in 1..M) {
            dp[i][j] = dp[i - 1][j]
            if (j == 1) dp[i][j] = maxOf(dp[i][j], sum[i])
            for (k in 2..i) {
                dp[i][j] = maxOf(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1])
            }
        }
    }

    print(dp[N][M])
}
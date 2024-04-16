import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val dp = Array(N) {StringTokenizer(br.readLine()).run { IntArray(3) { nextToken().toInt() } }}

    for (idx in 1 until N) {
        dp[idx][0] += minOf(dp[idx - 1][1], dp[idx - 1][2])
        dp[idx][1] += minOf(dp[idx - 1][0], dp[idx - 1][2])
        dp[idx][2] += minOf(dp[idx - 1][0], dp[idx - 1][1])
    }

    print(minOf(dp[N - 1][0], dp[N - 1][1], dp[N - 1][2]))
}
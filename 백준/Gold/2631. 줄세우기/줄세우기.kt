import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val kids = Array<Int>(N) { 0 }
    for (i in 0 until N) {
        kids[i] = br.readLine().toInt()
    }

    val dp = Array<Int>(N) { 0 }
    var max = 0

    for (i in 0 until N) {
        dp[i] = 1
        for (j in 0 until i) {
            if (kids[j] < kids[i] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1
                max = Math.max(max, dp[i])
            }
        }
    }

    print(N - max)
}
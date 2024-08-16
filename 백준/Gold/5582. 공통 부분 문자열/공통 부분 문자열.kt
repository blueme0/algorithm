import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine()
    val second = br.readLine()
    val dp = Array(first.length + 1) { IntArray(second.length + 1) { 0 } }
    var max = 0

    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                max = Math.max(max, dp[i][j])
            }
        }
    }

    print(max)
}
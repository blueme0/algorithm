import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine()
    val second = br.readLine()
    val flen = first.length
    val slen = second.length
    val dp = Array(flen + 1) { IntArray(slen + 1) { 0 } }
    var max = 0

    for (i in 1..flen) {
        for (j in 1..slen) {
            if (first[i - 1] == second[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
                max = maxOf(max, dp[i][j])
            }
        }
    }

    print(max)
}
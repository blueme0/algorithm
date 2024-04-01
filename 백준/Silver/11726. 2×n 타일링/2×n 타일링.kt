import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array<Int>(n + 1) { 0 }
    dp[0] = 1
    dp[1] = 1

    for (i in 2 .. n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    print(dp[n])
}
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val dp = mutableListOf<Int>(0, 0)
    for (i in 2 .. n) {
        dp.add(dp[i - 1] + 1)

        if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1)
        if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1)
    }

    print(dp[n])
}
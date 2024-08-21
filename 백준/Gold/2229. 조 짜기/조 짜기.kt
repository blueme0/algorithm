import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(N) { 0 }
    var increase = arr[1] > arr[0]
    dp[1] = Math.abs(arr[1] - arr[0])

    for (i in 2 until N) {
        val cur = arr[i] - arr[i - 1]
        if (cur > 0 == increase) {
            dp[i] = dp[i - 1] + Math.abs(cur)
        } else {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + Math.abs(cur))
            increase = !increase
        }
    }

    print(dp[N - 1])
}
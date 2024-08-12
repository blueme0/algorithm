import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(N + 1) { 1 }

    if (K == 1) {
        print(1)
        return
    }

    repeat(K - 2) {
        for (i in 1..N) {
            dp[i] += dp[i - 1]
            dp[i] %= 1_000_000_000
        }
    }

    var sum = 0
    for (i in 0..N) {
        sum += dp[i]
        sum %= 1_000_000_000
    }
    print(sum)
}

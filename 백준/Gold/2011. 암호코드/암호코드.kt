import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val crypto = br.readLine().toCharArray()
    val dp = Array(crypto.size) { IntArray(2) { 0 } }
    dp[0][0] = 1
    // 직전 글자가 2글자임 = dp[k][1], 1글자였음 dp[k][0]

    if (crypto[0] == '0') {
        print(0)
        return
    }

    for (i in 1 until crypto.size) {
        val cur = crypto[i]
        if (crypto[i] == '0') {
            if (crypto[i - 1] in '3'..'9') {
                print(0)
                return
            }
        } else {
            dp[i][0] += dp[i - 1][0] + dp[i - 1][1]
            dp[i][0] %= 1_000_000
        }
        if (crypto[i - 1] == '1') {
            dp[i][1] += dp[i - 1][0]
            dp[i][1] %= 1_000_000
        } else if (crypto[i - 1] == '2' && cur < '7') {
            dp[i][1] += dp[i - 1][0]
            dp[i][1] %= 1_000_000
        }
    }

    print((dp[crypto.size - 1][0] + dp[crypto.size - 1][1]) % 1_000_000)
}
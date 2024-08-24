import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val stone = BooleanArray(N + 1) { true }
    repeat(M) {
        stone[br.readLine().toInt()] = false
    }
    if (!stone[2]) {
        print(-1)
        return
    }

    val len = sqrt(2.0 * N).toInt()
    val dp = Array(N + 1) { Array(len + 1) { N + 1 } }
    // 최대 점프 거리가 201이라고 가정 -> N이 maximum일 때

    dp[1][0] = 0
    for (i in 2..N) {
        if (!stone[i]) continue
        val max = sqrt(2.0 * i).toInt()
        for (j in 1..max) {
            if (i - j <= 0) continue
            dp[i][j] = minOf(dp[i - j][j - 1] + 1, dp[i - j][j] + 1)
            if (j == max) continue
            dp[i][j] = minOf(dp[i][j], dp[i - j][j + 1] + 1)
        }
    }

    var ans = N + 1
    for (i in 0..len) {
        ans = minOf(ans, dp[N][i])
    }

    print(ans)

}
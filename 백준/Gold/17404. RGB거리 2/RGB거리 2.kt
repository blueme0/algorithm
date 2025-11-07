import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val INF = 1_000_001

    val N = st.nextToken().toInt()
    // cost[i][j] : i번째의 집을 j 색으로 채우는 경우
    val cost: Array<IntArray> = Array(N + 1) { IntArray(3) }

    for (i in 1..N) {
        st = StringTokenizer(br.readLine())
        for (j in 0..2) {
            cost[i][j] = st.nextToken().toInt()
        }
    }

    val dp: Array<IntArray> = Array(N + 1) { IntArray(3) }
    var answer = INF
    for (first in 0..2) {
        dp[1][first] = cost[1][first]
        for (other in 0..2) {
            if (first != other) dp[1][other] = INF
        }

        for (i in 2..N) {
            dp[i][0] = minOf(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]
            dp[i][1] = minOf(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]
            dp[i][2] = minOf(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]
        }

        for (last in 0..2) {
            if (first != last) answer = minOf(answer, dp[N][last])
        }
    }

    println(answer)
}
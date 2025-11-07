import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()

    val W: Array<IntArray> = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            W[i][j] = st.nextToken().toInt()
        }
    }

    val INF = 16_000_001

    val dp: Array<IntArray> = Array(N) { IntArray(1 shl N) { INF } }
    dp[0][1] = 0 // 사이클이기 때문에.. 무조건 0번에서 시작한다고 가정해도 괜찮음 순서가 더 중요!

    for (mask in 1 until (1 shl N)) {
        for (i in 0 until N) {
            // i..는 방문할 도시
            if ((mask and (1 shl i)) == 0) continue
            // 방문한 i에 대해서만 다음 대비!!
            for (j in 0 until N) {
                if ((mask and (1 shl j)) != 0) continue // j는 새로운 거
                if (W[i][j] == 0) continue // 못 가는 경로
                val nextMask = mask or (1 shl j)
                dp[j][nextMask] = minOf(dp[j][nextMask], dp[i][mask] + W[i][j])
            }
        }
    }

    var ans = INF
    for (i in 0 until N) {
        if (W[i][0] != 0) {
            ans = minOf(ans, dp[i][(1 shl N) - 1] + W[i][0])
        }
    }

    print(ans)
}
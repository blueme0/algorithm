import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()

    val dp = Array(N + 1) { LongArray(M + 1) { 0L } }
    val right = Array(N + 1) { BooleanArray(M + 1) { false } }
    val up = Array(N + 1) { BooleanArray(M + 1) { false } }

    repeat(K) {
        var st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        val d = st.nextToken().toInt()

        if (a == c) {
            val big = maxOf(b, d)
            up[a][big] = true
        } else {
            val big = maxOf(a, c)
            right[big][b] = true
        }
    }

    dp[0][0] = 1
    for (i in 1..N) {
        if (!right[i][0]) dp[i][0] += dp[i - 1][0]
    }
    for (j in 1..M) {
        if (!up[0][j]) dp[0][j] += dp[0][j - 1]
    }

    for (i in 1..N) {
        for (j in 1..M) {
            if (!right[i][j]) dp[i][j] += dp[i - 1][j]
            if (!up[i][j]) dp[i][j] += dp[i][j - 1]
        }
    }

    print(dp[N][M])
}
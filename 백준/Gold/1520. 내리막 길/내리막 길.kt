import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var M = 0
var N = 0
var map = arrayOf(IntArray(0))
var dp = arrayOf(IntArray(0))
val dm = arrayOf(0, 0, 1, -1)
val dn = arrayOf(1, -1, 0, 0)
var visited = arrayOf(BooleanArray(0))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    M = st.nextToken().toInt()
    N = st.nextToken().toInt()
    map = Array(M) { IntArray(N) { 0 } }
    dp = Array(M) { IntArray(N) { -1 } }
    dp[M - 1][N - 1] = 1

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    dfs(0, 0)
    print(if (dp[0][0] == -1) 0 else dp[0][0])
}

fun dfs(m: Int, n: Int): Int {
    // if (visited[m][n] && dp[m][n] == 0) return
    // visited[m][n] = true
    // 위 visited == false인 경우는 dp[m][n] == -1과 같다고 가정.
    // visited = true를 위해 dp[m][n] = 0을 수행하기
    // 이에 따라 미방문 시 -1, 방문했으나 이동 방법이 없으면 0, 방문했고 방법 있으면 1 이상
    if (m == M - 1 && n == N - 1) return 1
    dp[m][n] = 0

    for (i in 0..3) {
        val newM = m + dm[i]
        val newN = n + dn[i]
        if (newM == 0 && newN == 0) continue
        if (newM >= 0 && newM < M && newN >= 0 && newN < N && dp[newM][newN] != 0 && map[m][n] > map[newM][newN]) {
            // 유효성 검사
            if (dp[newM][newN] > 0) dp[m][n] += dp[newM][newN]
            else dp[m][n] += dfs(newM, newN)
        }
    }
    return dp[m][n]
}
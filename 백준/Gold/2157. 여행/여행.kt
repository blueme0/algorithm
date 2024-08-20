import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val dp = Array(N + 1) { IntArray(N + 1) { -1 } }
    val arr = Array(N + 1) { IntArray(N + 1) { -1 } }

    for (i in 0 until K) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if (a >= b) continue

        arr[a][b] = maxOf(arr[a][b], st.nextToken().toInt())
    }

    dp[1][1] = 0
    for (cur in 1 until N) {
        for (cnt in 1 until M) {
            if (dp[cur][cnt] == -1) continue

            for (next in cur + 1 .. N) {
                if (arr[cur][next] == -1) continue
                dp[next][cnt + 1] = maxOf(dp[next][cnt + 1], dp[cur][cnt] + arr[cur][next])
            }
        }
    }

    print(dp[N].max())
}
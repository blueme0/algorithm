import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(N) { BooleanArray(N) { false } }

    dp[0][0] = true
    for (i in 1 until N) {
        dp[i][i] = true
        if (arr[i] == arr[i - 1]) dp[i - 1][i] = true
    }

    for (j in 2 until N) {
        for (i in j - 2 downTo 0) {
            if (arr[i] == arr[j] && dp[i + 1][j - 1]) dp[i][j] = true
        }
    }

    var st = StringTokenizer(br.readLine())
    val M = st.nextToken().toInt()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(M) {
        st = StringTokenizer(br.readLine())
        if (dp[st.nextToken().toInt() - 1][st.nextToken().toInt() - 1]) bw.write("1\n") else bw.write("0\n")
    }
    bw.flush()
    bw.close()

}
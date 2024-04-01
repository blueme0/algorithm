import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    val dp = Array<Int>(11) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4 .. 10) {
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }

    repeat(N) {
        val num = br.readLine().toInt()
        bw.write("${dp[num]}\n")
    }
    bw.flush()
    bw.close()
}

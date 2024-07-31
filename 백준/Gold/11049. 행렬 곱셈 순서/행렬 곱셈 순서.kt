import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = IntArray(501) { 0 }
    val dp = Array(501) { IntArray(501) { 0 } }

    val first = br.readLine().split(" ").map { it.toInt() }
    arr[0] = first[0]
    arr[1] = first[1]

    for (i in 1 until N) {
        val c = br.readLine().split(" ")[1].toInt()
        arr[i + 1] = c
//        dp[i][i] = 0
        dp[i][i + 1] = arr[i - 1] * arr[i] * arr[i + 1]
    }

    for (len in 2 until N) {
        // len : 구간의 길이
        for (i in 1..N - len) {
            // dp[i][i + len] : i ~ i + len까지의 최소 곱셈 연산 수
            var min = Int.MAX_VALUE
            // 반복 계산이 나오는 부분은 temp에 임시 저장
            val temp = arr[i - 1] * arr[i + len]
            for (j in i until i + len) {
                val value = dp[i][j] + dp[j + 1][i + len] + arr[j] * temp
//                println("$i ~ ${i + len} = $min vs $value")
                min = Math.min(min, value)
            }
            dp[i][i + len] = min
        }
    }

    print(dp[1][N])
}
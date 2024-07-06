import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

const val MAX_VALUE = 100000001

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val S = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    // 누적합 저장
    val acc = Array<Int>(N + 1) { 0 }
    for (i in 1..N) {
        acc[i] = acc[i - 1] + st.nextToken().toInt()
    }

    var start = 0
    var end = 0
    var min = MAX_VALUE

    while (start <= N) {
        val cur = acc[end] - acc[start]

        if (cur < S) {
            // 부분합이 S보다 작을 때
            // end가 마지막에 왔는데 cur이 S보다 작다면 break
            if (end == N) break
            end++
        } else {
            // 부분합이 S보다 크거나 같을 때
            min = Math.min(min, end - start)
            start++
        }
    }

    if (min == MAX_VALUE) print(0)
    else print(min)
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()

    val max = Array(N) { IntArray(3) }
    val min = Array(N) { IntArray(3) }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        max[i][0] = st.nextToken().toInt()
        max[i][1] = st.nextToken().toInt()
        max[i][2] = st.nextToken().toInt()
        min[i][0] = max[i][0]
        min[i][1] = max[i][1]
        min[i][2] = max[i][2]
    }

    for (i in N - 2 downTo 0) {
        val maxFirst = max(max[i + 1][0], max[i + 1][1])
        max[i][0] += maxFirst
        val maxSecond = max(max[i + 1][1], max[i + 1][2])
        max[i][2] += maxSecond
        max[i][1] += max(maxFirst, maxSecond)

        val minFirst = min(min[i + 1][0], min[i + 1][1])
        min[i][0] += minFirst
        val minSecond = min(min[i + 1][1], min[i + 1][2])
        min[i][2] += minSecond
        min[i][1] += min(minFirst, minSecond)
    }

    print("${max(max(max[0][0], max[0][1]), max[0][2])} ${min(min(min[0][0], min[0][1]), min[0][2])}")
}
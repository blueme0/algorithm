import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val lectures = br.readLine().split(" ").map { it.toInt() }
    var total_time = 0
    var max_time = 0
    for (l in lectures) {
        total_time += l
        max_time = Math.max(l, max_time)
    }

    var low = max_time
    var high = total_time
    var mid = 0

    while (low <= high) {
        var cnt = 0 // 블루레이 수
        var sum = 0
        mid = (low + high) / 2

        for (i in 0 until N) {
            sum += lectures[i]
            if (sum > mid) {
                sum = lectures[i]
                cnt++
            }
        }

        if (sum > 0) cnt++
        if (cnt <= M) high = mid - 1
        else low = mid + 1
    }

    print(low)
}
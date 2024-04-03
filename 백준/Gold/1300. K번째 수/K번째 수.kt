import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val k = br.readLine().toInt()

    /**
     * 각 i번째 행에 대해 -> min(N, middle/i)
     */

    var start = 1
    var end = k
    var mid = 0
    var answer = 0

    while (start <= end) {
        mid = (start + end) / 2
        val sum = getSum(N, mid)
        if (sum < k) {
            start = mid + 1
        } else {
            end = mid - 1
            answer = mid
        }
    }

    print(answer)
}

private fun getSum(n: Int, mid: Int): Long {
    var sum = 0L
    for (i in 1..n) {
        sum += Math.min(n, mid / i)
    }
    return sum
}
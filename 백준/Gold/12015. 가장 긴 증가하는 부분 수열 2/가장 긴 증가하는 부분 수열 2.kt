import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
var arr = IntArray(0) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    val ai = br.readLine().split(" ").map { it.toInt() }
    arr = IntArray(N) { 0 }

    var len = 1
    arr[0] = ai[0]

    for (i in 1 until N) {
        if (arr[len - 1] < ai[i]) {
            arr[len] = ai[i]
            len++
        } else {
            var left = 0
            var right = len - 1
            while (left < right) {
                val mid = (left + right) ushr 1
                if (ai[i] > arr[mid]) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            arr[right] = ai[i]
        }
    }
    print(len)
}
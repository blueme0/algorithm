import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array<Int>(N) { 0 }
    for (i in N - 1 downTo 0) {
        arr[i] = br.readLine().toInt()
    }

    var rest = K
    var count = 0
    for (i in 0 until N) {
        if (rest == 0) break
        count += rest / arr[i]
        rest %= arr[i]
    }

    print(count)
}
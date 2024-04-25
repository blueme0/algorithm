import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val tree = br.readLine().split(" ").map { it.toInt() }

    var min = 0
    var max = tree.max()

    while (min < max) {
        val mid = (min + max) / 2
        var sum = 0L

        for (t in tree) {
            if (t - mid > 0) sum += t - mid
        }

        if (sum < M) {
            max = mid
        } else {
            min = mid + 1
        }
    }
    print(min - 1)
}
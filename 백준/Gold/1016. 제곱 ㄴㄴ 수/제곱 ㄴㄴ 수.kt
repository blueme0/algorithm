import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (min, max) = br.readLine().split(" ").map { it.toLong() }
    val minus = (max - min).toInt()
    val sqrt = Math.sqrt(max.toDouble()).toInt()

    val check = BooleanArray(minus + 1) { true }

    for (i in 2..sqrt) {
        val squared = i.toLong() * i
        val start = if (min % squared == 0L) min / squared else min / squared + 1
        var j = start
        while (j * squared <= max) {
            check[(j * squared - min).toInt()] = false
            j++
        }
    }

    var count = 0
    for (i in 0..minus) {
        if (check[i]) count++
    }

    print(count)
}
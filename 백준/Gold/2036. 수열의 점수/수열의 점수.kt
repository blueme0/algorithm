import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val positive = PriorityQueue<Int>(reverseOrder())
    val negative = PriorityQueue<Int>()
    var zero = false
    var total = 0L

    repeat(n) {
        val cur = br.readLine().toInt()
        if (cur > 1) positive.add(cur)
        else if (cur == 1) total++
        else if (cur == 0) zero = true
        else negative.add(cur)
    }

    val posLen = positive.size / 2
    val negLen = negative.size / 2

    repeat(posLen) {
        val first = positive.poll().toLong()
        val second = positive.poll().toLong()
        total += first * second
    }
    repeat(negLen) {
        val first = negative.poll().toLong()
        val second = negative.poll().toLong()
        total += first * second
    }

    if (positive.isNotEmpty()) total += positive.poll()
    if (negative.isNotEmpty()) {
        if (zero) negative.poll() else total += negative.poll()
    }

    print(total)
}
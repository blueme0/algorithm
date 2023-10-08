import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ")
    val balloon = ArrayDeque((1..N).map{
        Balloon(arr[it - 1].toInt(), it)
    })

    val sb = StringBuilder()

    for (i in 0 until N) {
        val now = balloon.pollFirst()
        sb.append(now.index.toString() + " ")
        if (balloon.isEmpty()) break
        if (now.value > 0) {
            for (j in 1 until now.value) {
                balloon.offerLast(balloon.pollFirst())
            }
        }
        else {
            for (j in 1..now.value.absoluteValue) {
                balloon.offerFirst(balloon.pollLast())
            }
        }
    }
    print(sb.toString())
}

data class Balloon (val value: Int, val index: Int)
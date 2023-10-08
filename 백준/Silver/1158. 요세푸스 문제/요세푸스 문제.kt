import java.util.*

fun main() {
    val input = System.`in`.bufferedReader().readLine().split(" ")
    var N = input[0].toInt()
    val K = input[1].toInt()

    val queue = mutableListOf<Int>()
    val stack = (1..N).toMutableList()
    var pos = 0
    while (N > 0) {
        pos += (K - 1)
        if (pos >= N) {
            pos %= N
        }
        queue.add(stack.removeAt(pos))
        N -= 1
    }

    print("<" + queue.joinToString(", ") + ">")
}
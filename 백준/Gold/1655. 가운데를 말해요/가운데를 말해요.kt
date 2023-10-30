import java.lang.StringBuilder
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val firstPQ = PriorityQueue<Int>(Comparator { o1, o2 -> o2 - o1 }) // (5, 4, 3, 2, 1)
    val secondPQ = PriorityQueue<Int>() // (6, 7, 8, 9, 10)
    var firstSize = 0
    var secondSize = 0
    val sb = StringBuilder()

    for (i in 0 until N) {
        val new = br.readLine().toInt()
        if (secondPQ.isEmpty() || new < secondPQ.first()) {
            firstPQ.offer(new)
            firstSize++
        }
        else {
            secondPQ.offer(new)
            secondSize++
        }
        if (firstSize < secondSize) {
            firstPQ.offer(secondPQ.poll())
            firstSize++
            secondSize--
        }
        if (firstSize > secondSize + 1) {
            secondPQ.offer(firstPQ.poll())
            firstSize--
            secondSize++
        }
        sb.appendLine(firstPQ.first())
    }
    print(sb)
}
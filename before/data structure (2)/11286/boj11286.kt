import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    val comparator = object : Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            if (o1!!.absoluteValue != o2!!.absoluteValue) return o1!!.absoluteValue - o2!!.absoluteValue
            else return o1 - o2
        }
    }

    val pq = PriorityQueue<Int>(comparator)
    for (i in 0 until N) {
        val num = br.readLine().toInt()
        if (num == 0) {
            if (pq.isEmpty()) {
                println(0)
            }
            else {
                println(pq.poll())
            }
        }
        else {
            pq.offer(num)
        }
    }
}
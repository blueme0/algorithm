import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val pq = PriorityQueue<Int>()

    for (i in 1..N) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until N) {
            pq.add(line[j])
        }
        while (pq.size != N) {
            pq.poll()
        }
    }

    println(pq.poll())
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, L) = br.readLine().split(" ").map { it.toInt() }

    val pq = PriorityQueue<Water>()

    repeat(N) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        pq.add(Water(start, end))
    }

    var cnt = 0
    var idx = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (idx >= cur.end) continue
        if (idx < cur.start) idx = cur.start

        val times = ((cur.end - idx) - 1) / L + 1
        cnt += times
        idx += L * times
    }
    print(cnt)
}

data class Water(val start: Int, val end: Int): Comparable<Water> {
    override fun compareTo(other: Water): Int {
        return start - other.start
    }
}
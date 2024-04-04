import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pq = PriorityQueue<Int>()
    val N = br.readLine().toInt()
    repeat(N) {
        pq.add(br.readLine().toInt())
    }
    var count = 0L

    while (pq.size > 1) {
        val result = pq.poll() + pq.poll()
        count += result
        pq.add(result)
    }

    print(count)
}
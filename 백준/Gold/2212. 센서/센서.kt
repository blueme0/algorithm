import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val K = br.readLine().toInt()
    val sensors = br.readLine().split(" ").map { it.toInt() }.sorted().toMutableList()
    val pq = PriorityQueue<Int>()

    for (i in N - 1 downTo 1) {
        sensors[i] -= sensors[i - 1]
    }
    sensors[0] = 0

    pq.addAll(sensors)

    var total = 0
    for (i in 0 .. N - K) {
        total += pq.poll()
    }

    print(total)
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var times = Array(0) { ArrayList<Node>() }
var rev_times = Array(0) { ArrayList<Node>() }
var N = 0
var dist = Array(0) { 0 }
var rev_dist = Array(0) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val X = st.nextToken().toInt()
    times = Array(N + 1) { ArrayList<Node>() }
    rev_times = Array(N + 1) { ArrayList<Node>() }
    dist = Array(N + 1) { Int.MAX_VALUE }
    rev_dist = Array(N + 1) { Int.MAX_VALUE }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val time = st.nextToken().toInt()
        times[start].add(Node(end, time))
        rev_times[end].add(Node(start, time))
    }

    dijkstra(times, dist, X)
    dijkstra(rev_times, rev_dist, X)

    dist.onEachIndexed { index, i -> rev_dist[index] += i }
    print(rev_dist.max())
}

fun dijkstra(arr: Array<ArrayList<Node>>, result: Array<Int>, start: Int) {
    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))
    result[start] = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        for (next in arr[cur.u]) {
            if (result[next.u] > result[cur.u] + next.w) {
                result[next.u] = result[cur.u] + next.w
                pq.add(Node(next.u, result[next.u]))
            }
        }
    }
}

data class Node(val u: Int, val w: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return w - other.w
    }
}
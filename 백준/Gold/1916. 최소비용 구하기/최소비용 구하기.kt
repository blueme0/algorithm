import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var N = 0
var graph = arrayOf(ArrayList<Node>())
var visited = booleanArrayOf()
var dist = Array<Int>(0) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    val M = br.readLine().toInt()

    graph = Array(N + 1) { ArrayList<Node>() }
    visited = BooleanArray(N + 1) { false }
    dist = Array(N + 1) { Int.MAX_VALUE }

    var st = StringTokenizer(br.readLine())
    repeat(M) {
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val cost = st.nextToken().toInt()
        graph[start].add(Node(end, cost))

        st = StringTokenizer(br.readLine())
    }
    val start = st.nextToken().toInt()
    val end = st.nextToken().toInt()

    dijkstra(start)
    print(dist[end])
}

private fun dijkstra(s: Int) {
    val queue = PriorityQueue<Node>()
    queue.offer(Node(s, 0))
    dist[s] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        if (visited[cur.v]) continue
        visited[cur.v] = true

        for (node in graph[cur.v]) {
            val next = dist[cur.v] + node.w
            if (dist[node.v] > next) {
                queue.offer(Node(node.v, next))
                dist[node.v] = next
            }
        }
    }
}

data class Node(val v: Int, val w: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return w.compareTo(other.w)
    }
}
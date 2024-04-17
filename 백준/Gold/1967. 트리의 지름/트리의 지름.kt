import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var graph = arrayOf(ArrayList<Node>())
const val INF = 99_999_999

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    graph = Array(n + 1) { ArrayList<Node>() }

    repeat(n - 1) {
        st = StringTokenizer(br.readLine())
        val cmd = arrayOf(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        graph[cmd[0]].add(Node(cmd[1], cmd[2]))
        graph[cmd[1]].add(Node(cmd[0], cmd[2]))
    }

    val first = dijkstra(1)
    val second = dijkstra(first.first)
    print(second.second)
}

fun dijkstra(start: Int): Pair<Int, Int> {
    val visited = BooleanArray(n + 1) { false }
    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))

    val dist = IntArray(n + 1) { INF }
    dist[start] = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (visited[cur.node]) continue
        visited[cur.node] = true

        for (n in graph[cur.node]) {
            if (dist[n.node] > dist[cur.node] + n.weight) {
                dist[n.node] = dist[cur.node] + n.weight
                pq.add(Node(n.node, dist[n.node]))
            }
        }
    }

    var max = 1
    for (i in 2..n) {
        if (dist[i] < INF && dist[max] < dist[i]) {
            max = i
        }
    }
    return Pair(max, dist[max])
}

data class Node(val node: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}
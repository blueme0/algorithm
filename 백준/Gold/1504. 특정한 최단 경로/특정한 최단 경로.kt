import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var map = arrayOf(ArrayList<Node>())
var N = 0
const val INF = 99_999_999

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    val E = st.nextToken().toInt()

    map = Array(N + 1) { ArrayList<Node>() }

    repeat(E) {
        st = StringTokenizer(br.readLine())
        val cur = arrayOf(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        map[cur[0]].add(Node(cur[1], cur[2]))
        map[cur[1]].add(Node(cur[0], cur[2]))
    }

    st = StringTokenizer(br.readLine())
    val include = arrayOf(st.nextToken().toInt(), st.nextToken().toInt())

    val first_dist = dijkstra(1)
    val last_dist = dijkstra(N)
    val between = dijkstra(include[0])[include[1]]
    val result = Math.min(first_dist[include[0]] + between + last_dist[include[1]], first_dist[include[1]] + between + last_dist[include[0]])
    if (result >= INF) print(-1) else print(result)
}

fun dijkstra(start: Int): IntArray {
    val visited = BooleanArray(N + 1) { false }
    val dist = IntArray(N + 1) { INF }
    dist[start] = 0

    val queue = PriorityQueue<Node>()
    queue.add(Node(start, 0))

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        if (visited[cur.node]) continue
        visited[cur.node] = true

        for (n in map[cur.node]) {
            if (dist[n.node] > dist[cur.node] + n.weight) {
                dist[n.node] = dist[cur.node] + n.weight
                queue.add(Node(n.node, dist[n.node]))
            }
        }
    }
    return dist
}

data class Node(val node: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}
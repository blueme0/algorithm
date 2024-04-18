import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

var graph = arrayOf(ArrayList<Node>())
var n = 0
const val INF = 199_999_999
var parent = intArrayOf()
val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    graph = Array(n + 1) { ArrayList<Node>() }
    val m = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    repeat(m) {
        val cmd = arrayOf(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        graph[cmd[0]].add(Node(cmd[1], cmd[2]))
        st = StringTokenizer(br.readLine())
    }

    val start = st.nextToken().toInt()
    var end = st.nextToken().toInt()

    val dst = dijkstra(start, end)

    sb.appendLine(dst)

    val stack = mutableListOf<Int>()
    var count = 0
    while (true) {
        stack.add(end)
        count++
        if (end == start) break
        end = parent[end]
    }

    sb.appendLine(count)

    while (stack.isNotEmpty()) {
        sb.append("${stack.removeLast()} ")
    }

    print(sb)
}

fun dijkstra(start: Int, end: Int): Int {
    val visited = BooleanArray(n + 1) { false }
    parent = IntArray(n + 1) { 0 }
    val dst = IntArray(n + 1) { INF }
    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))
    dst[start] = 0

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (visited[cur.node]) continue
        visited[cur.node] = true

        for (n in graph[cur.node]) {
            if (dst[n.node] > dst[cur.node] + n.weight) {
                dst[n.node] = dst[cur.node] + n.weight
                pq.add(Node(n.node, dst[n.node]))
                parent[n.node] = cur.node
            }
        }
    }
    return dst[end]
}

data class Node(val node: Int, val weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}
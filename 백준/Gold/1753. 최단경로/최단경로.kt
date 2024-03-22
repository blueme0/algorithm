import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val V = st.nextToken().toInt()
    val E = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val K = st.nextToken().toInt()

    val visited = BooleanArray(V + 1) { false }
    val route = Array(V + 1) { ArrayList<Edge>() }
    val cost = IntArray(V + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Edge>()
    cost[K] = 0
    pq.add(Edge(K, 0))

    repeat(E) {
        st = StringTokenizer(br.readLine())
        val v = st.nextToken().toInt()
        val u = st.nextToken().toInt()
        val w = st.nextToken().toInt()

        route[v].add(Edge(u, w))
    }

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (visited[cur.u]) continue
        visited[cur.u] = true
        for (node in route[cur.u]) {
            if (cost[node.u] > cost[cur.u] + node.w){
                cost[node.u] = cost[cur.u] + node.w
                /**
                 * 왜 갱신하는 경우에만 pq에 추가하는지를 모르겠음
                 */
                pq.add(Edge(node.u, cost[node.u]))
            }
        }
    }

    for (i in 1 .. V) {
        if (cost[i] == Int.MAX_VALUE) bw.write("INF\n")
        else bw.write("${cost[i]}\n")
    }

    bw.flush()
    bw.close()
}

data class Edge (
    val u: Int,
    val w: Int
) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return w - other.w
    }
}
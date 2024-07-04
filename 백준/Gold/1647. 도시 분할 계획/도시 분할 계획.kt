import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0 // number of house
var M = 0 // number of road
var parent = arrayOf<Int>()
val pq = PriorityQueue<Edge>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    parent = Array<Int>(N + 1) { 0 }
    for (i in 1..N) parent[i] = i

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val v1 = st.nextToken().toInt()
        val v2 = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        pq.add(Edge(v1, v2, w))
    }

    var weight = 0
    var cnt = 0
    while (pq.isNotEmpty()) {
        if (cnt == N - 2) break
        val cur = pq.poll()
        val f1 = find(cur.v1)
        val f2 = find(cur.v2)
        if (f1 != f2) {
            union(f1, f2)
            weight += cur.w
            cnt++
        }
    }

    print(weight)
}

fun union(n1: Int, n2: Int) {
    if (n1 < n2) parent[n2] = n1
    else parent[n1] = n2
}

fun find(n: Int): Int {
    if (parent[n] == n) return n
    parent[n] = find(parent[n])
    return parent[n]
}

data class Edge(val v1: Int, val v2: Int, val w: Int): Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return w - other.w
    }
}
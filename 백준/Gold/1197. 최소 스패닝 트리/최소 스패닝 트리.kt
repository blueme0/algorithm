import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var V = 0
var E = 0
var parent = arrayOf<Int>()
var pq = PriorityQueue<Edge>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    V = st.nextToken().toInt()
    E = st.nextToken().toInt()
    parent = Array<Int>(V + 1) { 0 }

    for (i in 1..V) parent[i] = i

    repeat(E) {
        st = StringTokenizer(br.readLine())
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()
        val C = st.nextToken().toInt()
        pq.offer(Edge(A, B, C))
    }

    var weight = 0
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        val f1 = find(cur.v1)
        val f2 = find(cur.v2)
        if (f1 != f2) {
            union(f1, f2)
            weight += cur.w
        }
//        if (find(cur.v1) != find(cur.v2)) {
//            union(cur.v1, cur.v2)
//            weight += cur.w
//        }
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
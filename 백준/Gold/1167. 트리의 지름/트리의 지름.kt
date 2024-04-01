import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var N = 0
var arr = arrayOf(ArrayList<Node>())
var visited = booleanArrayOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    visited = BooleanArray(N + 1) { false }
    arr = Array(N + 1) { ArrayList<Node>() }

    repeat(N) {
        st = StringTokenizer(br.readLine())
        val cur = st.nextToken().toInt()
        var v = st.nextToken().toInt()
        while (v != -1) {
            val w = st.nextToken().toInt()
            arr[cur].add(Node(v, w))
            v = st.nextToken().toInt()
        }
    }

    var result = BFS(1)
    visited = BooleanArray(N + 1) { false }
    result = BFS(result.v)

    print(result.w)

}

data class Node (val v: Int, val w: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return w - other.w
    }
}

private fun BFS(s: Int): Node {
    val len = Array<Int>(N + 1) { 0 }
    len[s] = 0
    val queue = LinkedList<Node>()
    queue.add(Node(s, 0))
    var max = Node(s, 0)
    visited[s] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (n in arr[cur.v]) {
            if (!visited[n.v]) {
                if (len[n.v] == 0) {
                    len[n.v] = len[cur.v] + n.w
                    if (len[n.v] > len[max.v]) {
                        max = n
                    }
                    visited[n.v] = true
                    queue.add(n)
                }
            }
        }
    }
    return Node(max.v, len[max.v])
}
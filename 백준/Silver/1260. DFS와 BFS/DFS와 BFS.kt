import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var visited = booleanArrayOf()
var graph = arrayOf(ArrayList<Int>())
var bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val V = st.nextToken().toInt()

    graph = Array(N + 1) { ArrayList<Int>() }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val v = st.nextToken().toInt()
        val u = st.nextToken().toInt()

        graph[v].add(u)
        graph[u].add(v)
    }

    for (i in 1 .. N) {
        graph[i].sort()
    }

    visited = BooleanArray(N + 1) { false }
    DFS(V)
    bw.write("\n")
    bw.flush()

    visited = BooleanArray(N + 1) { false }
    BFS(V)
    bw.flush()
    bw.close()
}

fun DFS(v: Int) {
    bw.write("$v ")
    visited[v] = true
    for (i in graph[v]) {
        if (!visited[i]) DFS(i)
    }
}

fun BFS(v: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(v)
    visited[v] = true
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        bw.write("$cur ")
        for (i in graph[cur]) {
            if (!visited[i]) {
                visited[i] = true
                queue.add(i)
            }
        }
    }
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var visited = booleanArrayOf()
var graph = arrayOf(ArrayList<Int>())

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    visited = BooleanArray(N + 1) { false }
    graph = Array(N + 1) { ArrayList<Int>() }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()

        graph[u].add(v)
        graph[v].add(u)
    }

    var count = 0
    for (i in 1..N) {
        if (!visited[i]) {
            count++
            DFS(i)
        }
    }
    print(count)
}

fun DFS(v: Int) {
    if (visited[v]) return
    visited[v] = true
    for (i in graph[v]) {
        if (!visited[i]) DFS(i)
    }
}

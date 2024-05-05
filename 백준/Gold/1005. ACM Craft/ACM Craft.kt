import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var N = 0
var building = arrayOf<Int>(0)
var connections = arrayOf(ArrayList<Int>())
var visited = booleanArrayOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val T = st.nextToken().toInt()
    val sb = StringBuilder()

    repeat(T) {
        st = StringTokenizer(br.readLine())
        N = st.nextToken().toInt()
        val K = st.nextToken().toInt()
        building = Array(N + 1) { 0 }
        connections = Array(N + 1) { ArrayList<Int>() }
        visited = BooleanArray(N + 1) { false }
        st = StringTokenizer(br.readLine())
        for (i in 1..N) {
            building[i] = st.nextToken().toInt()
        }
        repeat(K) {
            st = StringTokenizer(br.readLine())
            val start = st.nextToken().toInt()
            val end = st.nextToken().toInt()
            connections[end].add(start)
        }
        st = StringTokenizer(br.readLine())
        sb.appendLine(dfs(st.nextToken().toInt()))
    }
    print(sb)
}

fun dfs(cur: Int): Int {
    if (visited[cur]) return building[cur]
    visited[cur] = true
    var max = 0
    for (i in connections[cur]) {
        max = Math.max(max, dfs(i))
    }
    building[cur] += max
    return building[cur]
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

var friends = arrayOf(PriorityQueue<Int>())
var visited = BooleanArray(0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    friends = Array(N) { PriorityQueue<Int>() }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        friends[a].add(b)
        friends[b].add(a)
    }

    var succeed = 0
    for (i in 0 until N) {
        visited = BooleanArray(N) { false }
        val result = DFS(i, 1)
        if (result) {
            succeed = 1
            break
        }
    }

    print(succeed)
}

fun DFS(a: Int, d: Int): Boolean {
    if (visited[a]) return false
    visited[a] = true

    if (d == 5) return true

    var result = false
    for (i in friends[a]) {
        if (!visited[i]) {
            result = DFS(i, d + 1)
            if (result) break
        }
    }
    if (!result) visited[a] = false
    return result
}
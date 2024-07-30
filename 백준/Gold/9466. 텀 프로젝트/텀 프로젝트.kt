import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var checked = BooleanArray(0) { false }
var visited = BooleanArray(0) { false }
var students = IntArray(0) { 0 }
var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val T = st.nextToken().toInt()
    val sb = StringBuilder()

    repeat(T) {
        st = StringTokenizer(br.readLine())
        n = st.nextToken().toInt()
        cnt = n
        students = IntArray(n + 1) { 0 }

        st = StringTokenizer(br.readLine())
        for (i in 1..n) {
            students[i] = st.nextToken().toInt()
        }
        visited = BooleanArray(n + 1) { false }
        checked = BooleanArray(n + 1) { false }

        for (i in 1..n) {
            if (!checked[i]) dfs(i)
        }

        sb.appendLine("$cnt")
    }

    print(sb)
}

fun dfs(cur: Int) {
    visited[cur] = true
    var next = students[cur]

    if (!visited[next]) {
        dfs(next)
    } else {
        if (!checked[next]) {
            cnt--

            while (cur != next) {
                cnt--
                next = students[next]
            }
        }
    }

    checked[cur] = true
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var n = 0
var finished = BooleanArray(100_001) { false }
var visited = BooleanArray(100_001) { false }
var students = IntArray(100_001) { 0 }
var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        n = br.readLine().toInt()
        cnt = n

        val line = br.readLine()
        line.split(" ").forEachIndexed { index, s -> students[index + 1] = s.toInt() }
        visited.fill(false)
        finished.fill(false)

        for (i in 1..n) {
            if (!finished[i]) dfs(i)
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
        if (!finished[next]) {
            cnt--

            while (cur != next) {
                cnt--
                next = students[next]
            }
        }
    }

    finished[cur] = true
}
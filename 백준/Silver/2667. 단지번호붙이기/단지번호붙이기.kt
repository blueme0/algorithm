import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var map = arrayOf(booleanArrayOf())
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    map = Array(N) { BooleanArray(N) { false } }

    for (i in 0 until N) {
        val line = br.readLine()
        for (j in 0 until N) {
            if (line[j] == '1') {
                map[j][i] = true
            }
        }
    }

    val pq = PriorityQueue<Int>()
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j]) {
                dfs(j, i)
                pq.add(count)
                count = 0
            }
        }
    }

    val sb = StringBuilder()
    sb.appendLine(pq.size)
    while (pq.isNotEmpty()) {
        sb.appendLine(pq.poll())
    }
    print(sb)
}

fun dfs(x: Int, y: Int) {
    count++
    map[y][x] = false

    for (i in 0 until 4) {
        val a = x + dx[i]
        val b = y + dy[i]
        if (a >= 0 && a < N && b >= 0 && b < N && map[b][a]) dfs(a, b)
    }
}
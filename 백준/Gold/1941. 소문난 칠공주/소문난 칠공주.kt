import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val N = 5
var sarr = Array(N) { BooleanArray(N) { false } }
var visited = BooleanArray(0)
var selected = Array<Int>(0) { 0 }

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    for (i in 0 until N) {
        val line = br.readLine()
        for (j in 0 until N) {
            sarr[i][j] = line[j] == 'S'
        }
    }

    // 2차원 배열 -> 1차원으로
    visited = BooleanArray(N * N) { false }
    // 선택된 7명
    selected = Array<Int>(7) { 0 }

    dfs(0, 0, 0)
    print(result)

}

private fun dfs(idx: Int, cnt: Int, sCnt: Int) {
    if (cnt == 7) {
        if (sCnt >= 4) {
            if (bfs()) result++
        }
        return
    }

    for (i in idx until N * N) {
        visited[i] = true
        selected[cnt] = i
        // 다솜파가 맞으면?
        if (sarr[i / N][i % N]) dfs(i + 1, cnt + 1, sCnt + 1)
        else dfs(i + 1, cnt + 1, sCnt)

        visited[i] = false // backtracking
    }
}

private fun bfs(): Boolean {
    var cnt = 0
    val nvisited = BooleanArray(N * N) { false }
    val queue = LinkedList<Int>()
    queue.add(selected[0])
    cnt++

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        nvisited[cur] = true

        for (i in 0 until 4) {
            val x = cur % N + dx[i]
            val y = cur / N + dy[i]
            if (x >= 0 && y >= 0 && x < N && y < N) {
                val new = x + y * N
                if (!nvisited[new] && visited[new]) {
                    cnt++
                    nvisited[new] = true
                    queue.add(new)
                }
            }
        }
    }
    return cnt == 7
}
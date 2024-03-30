import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var arr = arrayOf(Array<Int>(0) { 0 })
var visited = arrayOf(BooleanArray(0))
val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var N = 0
var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = br.readLine().split(" ").map { it.toInt() }
    N = nums[0]
    M = nums[1]

    arr = Array(N) { Array<Int>(M) { 0 } }
    visited  = Array(N) { BooleanArray(M) { false } }
    for (i in 0 until N) {
        val line = br.readLine()
        for (j in 0 until M) {
            if (line[j] == '1') arr[i][j] = 1
            else arr[i][j] = 0
        }
    }

    BFS(0, 0)
    print(arr[N - 1][M - 1])
}

private fun BFS(x: Int, y: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(x, y))
    visited[x][y] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in 0 until 4) {
            val newx = cur.first + dx[i]
            val newy = cur.second + dy[i]
            if (newx >= 0 && newy >= 0 && newx < N && newy < M) {
                if (arr[newx][newy] != 0 && !visited[newx][newy]) {
                    visited[newx][newy] = true
                    arr[newx][newy] = arr[cur.first][cur.second] + 1
                    queue.add(Pair(newx, newy))
                }
            }
        }
    }
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var M = 0
var N = 0

var arr = arrayOf(Array<Int>(0) { 0 })
var visited = arrayOf(BooleanArray(0))
var ripped = mutableListOf<Pair<Int, Int>>()
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    M = st.nextToken().toInt()
    N = st.nextToken().toInt()

    arr = Array(N) { Array<Int>(M) { 0 } }
    visited = Array(N) { BooleanArray(M) { false } }

    var goal = 0

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            arr[i][j] = st.nextToken().toInt()
            if (arr[i][j] == 1) ripped.add(Pair(j, i))
            if (arr[i][j] >= 0) goal++
        }
    }

    val result = BFS()

    if (count < goal) print(-1)
    else print(result - 1)
}

private fun BFS(): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.addAll(ripped)

    var max = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        count++
        max = arr[cur.second][cur.first]
        visited[cur.second][cur.first] = true
        
        for (i in 0 until 4) {
            val x = cur.first + dx[i]
            val y = cur.second + dy[i]

            if (x >= 0 && y >= 0 && x < M && y < N) {
                if (!visited[y][x] && arr[y][x] != -1) {
                    visited[y][x] = true
                    if (arr[y][x] == 0) {
                        queue.add(Pair(x, y))
                        arr[y][x] = arr[cur.second][cur.first] + 1
                    }
                    else arr[y][x] = Math.min(arr[y][x], arr[cur.second][cur.first] + 1)
                }
            }
        }
    }

    return max
}
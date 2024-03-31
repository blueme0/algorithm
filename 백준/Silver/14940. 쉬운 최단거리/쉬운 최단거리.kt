import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0

var visited = arrayOf(BooleanArray(0))
var arr = arrayOf(Array<Int>(0) { 0 })
var available = arrayOf(BooleanArray(0))

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    visited = Array(n) { BooleanArray(m) { false } }
    arr = Array(n) { Array<Int>(m) { -1 } }
    available = Array(n) { BooleanArray(m) { true } }

    var goalx = 0
    var goaly = 0

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            val cur = st.nextToken().toInt()
            if (cur == 0) {
                available[i][j] = false
                arr[i][j] = 0
            }
            if (cur == 2) {
                goaly = i
                goalx = j
            }
        }
    }

    BFS(goalx, goaly)

    for (i in 0 until n) {
        for (j in 0 until m) {
            bw.write("${arr[i][j]} ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

private fun BFS(a: Int, b: Int) {
    val queue = LinkedList<Point>()
    queue.add(Point(a, b))
    visited[b][a] = true
    arr[b][a] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in 0 until 4) {
            val x = cur.x + dx[i]
            val y = cur.y + dy[i]

            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!visited[y][x] && available[y][x]) {
                    queue.add(Point(x, y))
                    visited[y][x] = true
                    arr[y][x] = arr[cur.y][cur.x] + 1
                }
            }
        }
    }
}

data class Point(val x: Int, val y: Int)
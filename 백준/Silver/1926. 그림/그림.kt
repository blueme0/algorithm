import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var map = arrayOf(booleanArrayOf())
var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    map = Array(N) { BooleanArray(M) { false } }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            map[i][j] = st.nextToken().toInt() == 1
        }
    }

    var many = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j]) {
                many++
                max = Math.max(max, bfs(j, i))
            }
        }
    }
    print("$many\n$max")
}

fun bfs(a: Int, b: Int): Int {
    val queue: Queue<Point> = LinkedList()
    map[b][a] = false
    queue.add(Point(a, b))
    var count = 1

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in 0 until 4) {
            val x = cur.x + dx[i]
            val y = cur.y + dy[i]
            if (x >= 0 && x < M && y >= 0 && y < N && map[y][x]) {
                map[y][x] = false
                count++
                queue.add(Point(x, y))
            }
        }
    }

    return count
}

data class Point(val x: Int, val y: Int)
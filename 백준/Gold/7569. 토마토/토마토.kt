import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val queue: Queue<Point> = LinkedList()
var M = 0
var N = 0
var H = 0
var tomato = arrayOf(arrayOf(Array<Int>(0) { 0 }))
val dx = arrayOf(0, 0, 1, 0, 0, -1)
val dy = arrayOf(1, 0, 0, -1, 0, 0)
val dz = arrayOf(0, 1, 0, 0, -1, 0)
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    M = st.nextToken().toInt()
    N = st.nextToken().toInt()
    H = st.nextToken().toInt()

    tomato = Array(H) { Array(N) { Array(M) { 0 } } }

    for (z in 0 until H) {
        for (y in 0 until N) {
            st = StringTokenizer(br.readLine())
            for (x in 0 until M) {
                tomato[z][y][x] = st.nextToken().toInt()
                if (tomato[z][y][x] == 1) {
                    queue.add(Point(x, y, z))
                }
                else if (tomato[z][y][x] == 0) count++
            }
        }
    }

    val result = bfs()
    print(result)
}

fun bfs(): Int {
    var max = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in 0 until 6) {
            val x = cur.x + dx[i]
            val y = cur.y + dy[i]
            val z = cur.z + dz[i]

            if (x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H) {
                if (tomato[z][y][x] == 0) {
                    // 안 익은 토마토면!
                    count--
                    tomato[z][y][x] = tomato[cur.z][cur.y][cur.x] + 1
                    max = Math.max(tomato[z][y][x], max)
                    queue.add(Point(x, y, z))
                }
            }
        }
    }
    if (count > 0) return -1
    else if (max == 0) return 0
    else return max - 1
}

data class Point(val x: Int, val y: Int, val z: Int)
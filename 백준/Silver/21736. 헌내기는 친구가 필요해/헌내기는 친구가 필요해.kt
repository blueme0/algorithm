import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
var wall = arrayOf(booleanArrayOf())
var person = arrayOf(booleanArrayOf())
val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    N = cmd[0]
    M = cmd[1]
    wall = Array(N) { BooleanArray(M) { false } }
    person = Array(N) { BooleanArray(M) { false } }
    var doyeon = Point(0, 0)
    for (i in 0 until N) {
        val line = br.readLine()
        for (j in 0 until M) {
            if (line[j] == 'X') wall[i][j] = true
            else if (line[j] == 'P') person[i][j] = true
            else if (line[j] == 'I') doyeon = Point(j, i)
        }
    }
    val result = bfs(doyeon.x, doyeon.y)
    if (result == 0) print("TT") else print(result)
}

fun bfs(a: Int, b: Int): Int {
    val visited = Array(N) { BooleanArray(M) { false } }
    val queue: Queue<Point> = LinkedList()
    visited[b][a] = true
    queue.add(Point(a, b))
    var count = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in 0 until 4) {
            val x = cur.x + dx[i]
            val y = cur.y + dy[i]
            if (x >= 0 && x < M && y >= 0 && y < N && !wall[y][x]) {
                if (!visited[y][x]) {
                    if (person[y][x]) count++
                    visited[y][x] = true
                    queue.add(Point(x, y))
                }
            }
        }
    }
    return count
}

data class Point(val x: Int, val y: Int)
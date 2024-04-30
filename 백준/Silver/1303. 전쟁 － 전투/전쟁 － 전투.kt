import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var M = 0
val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var count = 0
var blue = arrayOf(booleanArrayOf())
var white = arrayOf(booleanArrayOf())

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    N = cmd[0] // 가로
    M = cmd[1] // 세로
    blue = Array(M) { BooleanArray(N) { false } }
    white = Array(M) { BooleanArray(N) { false } }

    for (i in 0 until M) {
        val line = br.readLine()
        for (j in 0 until N) {
            if (line[j] == 'W') {
                white[i][j] = true
            } else if (line[j] == 'B') {
                blue[i][j] = true
            }
        }
    }

    val queue : Queue<Int> = LinkedList()
    for (i in 0 until M) {
        for (j in 0 until N) {
            if (white[i][j]) {
                dfs(i, j, true)
                queue.add(count)
                count = 0
            }
        }
    }

    var white_total = 0L
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        white_total += cur.toLong() * cur.toLong()
    }

    count = 0
    for (i in 0 until M) {
        for (j in 0 until N) {
            if (blue[i][j]) {
                dfs(i, j, false)
                queue.add(count)
                count = 0
            }
        }
    }

    var blue_total = 0L
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        blue_total += cur.toLong() * cur.toLong()
    }

    print("$white_total $blue_total")
}

fun dfs(x: Int, y: Int, wh: Boolean) {
    count++
    if (wh) white[x][y] = false
    else blue[x][y] = false

    for (i in 0 until 4) {
        val a = x + dx[i]
        val b = y + dy[i]
        if (a >= 0 && a < M && b >= 0 && b < N) {
            if (wh && white[a][b] || !wh && blue[a][b]) dfs(a, b, wh)
        }
    }
}
import java.io.BufferedReader
import java.io.InputStreamReader

var R = 0
var C = 0
var map = arrayOf(Array<Char>(0) { ' ' })
var visited = booleanArrayOf()
const val ALPHABET = 26

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    R = cmd[0]
    C = cmd[1]

    map = Array(R) { Array<Char>(C) { ' ' } }
    visited = BooleanArray(ALPHABET) { false }

    for (i in 0 until R) {
        val line = br.readLine()
        for (j in 0 until C) {
            map[i][j] = line[j]
        }
    }

    backtracking(0, 0, 1)
    print(max)
}

fun backtracking(x: Int, y: Int, d: Int) {
    visited[map[y][x] - 'A'] = true

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
            if (visited[map[ny][nx] - 'A']) continue
            backtracking(nx, ny, d + 1)
        }
    }

    max = Math.max(max, d)
    visited[map[y][x] - 'A'] = false
}
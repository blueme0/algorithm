import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var R = 0
var C = 0
var K = 0
var count = 0
var wall = arrayOf(booleanArrayOf())
var visited = arrayOf(booleanArrayOf())
val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    R = cmd[0]
    C = cmd[1]
    K = cmd[2]
    wall = Array(R) { BooleanArray(C) { false } }
    visited = Array(R) { BooleanArray(C) { false } }
    for (i in 0 until R) {
        val line = br.readLine()
        for (j in 0 until C) {
            if (line[j] == 'T') wall[i][j] = true
        }
    }

    visited[R - 1][0] = true
    dfs(0, R - 1, 1)
    print(count)
}

fun dfs(a: Int, b: Int, depth: Int) {
    if (a == C - 1 && b == 0 && depth == K) {
        count++
        return
    }

    for (i in 0 until 4) {
        val x = a + dx[i]
        val y = b + dy[i]
        if (x >= 0 && x < C && y >= 0 && y < R && !wall[y][x] && !visited[y][x]) {
            visited[y][x] = true
            dfs(x, y, depth + 1)
            visited[y][x] = false
        }
    }
}
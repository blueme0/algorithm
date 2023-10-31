import java.lang.StringBuilder

val dirtX = arrayOf(0, 0, 1, -1)
val dirtY = arrayOf(1, -1, 0, 0)
lateinit var map: Array<Array<Int>>
var M = 0
var N = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val line = br.readLine().split(" ")
        M = line[0].toInt()
        N = line[1].toInt()
        val K = line[2].toInt()
        var count = 0

        map = Array(N) { Array(M) { 0 } }

        repeat(K) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            map[y][x] = 1
        }

        repeat(N) { y ->
            repeat(M) { x ->
                if (dfs(x, y)) count++
            }

        }
        sb.appendLine(count)
    }
    print(sb)
}

fun dfs(x: Int, y: Int): Boolean {
    if (map[y][x] == 0) return false

    map[y][x] = 0
    for (i in 0 until 4) {
        val nowX = x + dirtX[i]
        val nowY = y + dirtY[i]

        if (nowX < 0 || nowX >= M || nowY < 0 || nowY >= N || map[nowY][nowX] == 0) continue
        dfs(nowX, nowY)
    }
    return true
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs
import kotlin.math.min

const val HOME = 1
const val CHICKEN = 2
var N = 0
var M = 0
var chicken = ArrayList<Point>()
var home = ArrayList<Point>()
lateinit var visited: BooleanArray
val stack = mutableListOf<Point>()
var dist = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            val cur = st.nextToken().toInt()
            if (cur == HOME) home.add(Point(j, i))
            else if (cur == CHICKEN) chicken.add(Point(j, i))
        }
    }
    visited = BooleanArray(chicken.size) { false }

    backtracking(0, 0)
    print(dist)
}

data class Point(val x: Int, val y: Int)

fun backtracking(depth: Int, start: Int) {
    if (depth == M) {
        var ans = 0
        for (h in home) {
            var temp = Int.MAX_VALUE
            stack.forEach { p ->
                temp = min(temp, abs(h.x - p.x) + abs(h.y - p.y))
            }
            ans += temp
        }
        dist = min(ans, dist)
    }

    for (i in start until chicken.size) {
        visited[i] = true
        stack.add(chicken[i])
        backtracking(depth + 1, i + 1)
        stack.removeLast()
        visited[i] = false
    }
}
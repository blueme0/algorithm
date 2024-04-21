import java.io.BufferedReader
import java.io.InputStreamReader

val ts = mutableSetOf<String>()

var N = 0
var M = 0
var num = List<Int>(0) { 0 }
var visited = booleanArrayOf()
val stack = mutableListOf<Int>()
val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    N = cmd[0]
    M = cmd[1]
    num = br.readLine().split(" ").map { it.toInt() }.sorted()
    visited = BooleanArray(N) { false }

    backtracking(0)
    ts.forEach { sb.appendLine(it) }
    print(sb)
}

fun backtracking(depth: Int) {
    if (depth == M) {
        ts.add(stack.joinToString(" "))
        return
    }

    for (i in 0 until N) {
        if (!visited[i]) {
            visited[i] = true
            stack.add(num[i])
            backtracking(depth + 1)
            stack.removeLast()
            visited[i] = false
        }
    }
}
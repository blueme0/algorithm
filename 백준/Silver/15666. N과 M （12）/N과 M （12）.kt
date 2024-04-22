import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
var M = 0
var visited = booleanArrayOf()
val stack = mutableListOf<Int>()
val sb = StringBuilder()
var num = List<Int>(0) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    M = cmd[1]
    val set = mutableSetOf<Int>()
    br.readLine().split(" ").map { it.toInt() }.sorted().forEach { set.add(it) }
    num = set.toList()
    N = set.size
    visited = BooleanArray(num.size) { false }

    backtracking(0, 0)
    print(sb)
}

fun backtracking(depth: Int, start: Int) {
    if (depth == M) {
        sb.appendLine(stack.joinToString(" "))
        return
    }

    for (i in start until N) {
        visited[i] = true
        stack.add(num[i])
        backtracking(depth + 1, i)
        stack.removeLast()
        visited[i] = false
    }
}
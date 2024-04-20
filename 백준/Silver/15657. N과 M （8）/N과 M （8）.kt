import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
var N = 0
var M = 0
var num = List<Int>(0) { 0 }
var stack = mutableListOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    N = cmd[0]
    M = cmd[1]
    num = br.readLine().split(" ").map { it.toInt() }.sorted()

    backtracking(0, 0)
    print(sb)
}

fun backtracking(depth: Int, start: Int) {
    if (depth == M) {
        sb.appendLine(stack.joinToString(" "))
        return
    }

    for (i in start until N) {
        stack.add(num[i])
        backtracking(depth + 1, i)
        stack.removeLast()
    }
}
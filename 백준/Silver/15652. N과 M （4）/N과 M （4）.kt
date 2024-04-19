import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
var M = 0
val sb = StringBuilder()
val stack = mutableListOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    N = cmd[0]
    M = cmd[1]

    backtracking(1, 0)
    print(sb)
}

fun backtracking(start: Int, depth: Int) {
    if (depth == M) {
        sb.appendLine(stack.joinToString(" "))
        return
    }

    for (i in start .. N) {
        stack.add(i)
        backtracking(i, depth + 1)
        stack.removeLast()
    }
}
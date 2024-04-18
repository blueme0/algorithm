import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()
val stack = mutableListOf<Int>()
var N = 0
var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt()}
    N = cmd[0]
    M = cmd[1]

    for (i in 1..N) {
        backtracking(i, 1)
    }
    print(sb)
}

fun backtracking(now: Int, depth: Int) {
    stack.add(now)
    if (depth == M) {
        sb.appendLine(stack.joinToString(" "))
    } else {
        for (i in now + 1 ..N) {
            backtracking(i, depth + 1)
        }
    }
    stack.removeLast()
}
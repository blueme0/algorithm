import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }

    val stack = mutableListOf<Int>()

    val answer = IntArray(N) { 0 }

    val sb = StringBuilder()
    for (i in N - 1 downTo 0) {
        val cur = arr[i]

        while (stack.isNotEmpty()) {
            if (cur >= stack.last()) {
                stack.removeLast()
            } else {
                break
            }
        }
        if (stack.isEmpty()) answer[i] = -1
        else answer[i] = stack.last()
        stack.add(cur)
    }

    for (i in 0 until N) {
        sb.append("${answer[i]} ")
    }

    print(sb.toString())
}
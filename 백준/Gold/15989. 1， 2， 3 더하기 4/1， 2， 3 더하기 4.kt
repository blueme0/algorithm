import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val answer = IntArray(10_001) { 0 }
    answer[1] = 1
    answer[2] = 2
    answer[3] = 3
    for (i in 4..10_000) {
        answer[i] = 1 + i / 2 + answer[i - 3]
    }

    val K = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(K) {
        val cur = br.readLine().toInt()
        sb.appendLine("${answer[cur]}")
    }

    print(sb)
}
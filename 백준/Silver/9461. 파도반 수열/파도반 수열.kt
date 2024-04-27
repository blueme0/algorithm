import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    val len = Array<Long>(101) { 0L }
    len[1] = 1L
    len[2] = 1L
    len[3] = 1L
    len[4] = 2L
    len[5] = 2L
    for (i in 6..100) {
        len[i] = len[i - 1] + len[i - 5]
    }
    repeat(T) {
        sb.appendLine(len[br.readLine().toInt()])
    }
    print(sb)
}
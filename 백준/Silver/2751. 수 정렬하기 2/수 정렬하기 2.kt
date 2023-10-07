import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val numbers = TreeSet<Int>()
    val N = br.readLine().toInt()
    repeat(N) {
        numbers.add(br.readLine().toInt())
    }
    val sb = StringBuilder()
    for (i in numbers) {
        sb.appendLine(i)
    }
    print(sb.toString())
}
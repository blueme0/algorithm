import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val stack = mutableListOf<Int>()

    var num = 1

    for (i in 1..n) {
        val cur = br.readLine().toInt()
        while (num <= n && num <= cur) {
            stack.add(num)
            num++
            sb.appendLine("+")
        }
        if (stack.last() == cur) {
            stack.removeLast()
            sb.appendLine("-")
        }
        else {
            sb.clear()
            sb.append("NO")
            break
        }
    }

    print(sb.toString())
}
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line_minus = br.readLine().split("-")
    var result = 0
    for (i in line_minus.indices) {
        val sum = line_minus[i].split("+").map { it.toInt() }.sum()
        if (i == 0) {
            result += sum
        }
        else {
            result -= sum
        }
    }
    print(result)
}
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var isFirst = true

    var result = 0

    val minus = br.readLine().split("-")
    for (l in minus) {
        val plus = l.split("+").map { it.toInt() }
        var temp = 0
        for (n in plus) {
            temp += n
        }
        if (isFirst) {
            result = temp
            isFirst = false
        } else {
            result -= temp
        }
    }

    print(result)
}
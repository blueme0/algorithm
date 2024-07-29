import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val first = br.readLine()
    val second = br.readLine()

    val lcs = Array(first.length + 1) { Array<Int>(second.length + 1) { 0 } }

    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) lcs[i][j] = lcs[i - 1][j - 1] + 1
            else lcs[i][j] = max(lcs[i][j - 1], lcs[i - 1][j])
        }
    }

    val sb = StringBuilder()

    var i = first.length
    var j = second.length
    while (lcs[i][j] > 0) {
        if (first[i - 1] == second[j - 1]) {
            sb.append(first[i - 1])
            i--
            j--
        } else {
            if (lcs[i - 1][j] > lcs[i][j - 1]) i--
            else j--
        }
    }

    println(sb.length)
    print(sb.toString().reversed())
}
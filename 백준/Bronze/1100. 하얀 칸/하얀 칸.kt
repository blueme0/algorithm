import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 0
    for (i in 0 until 8) {
        val line = br.readLine()
        for (j in 0 until 8) {
            if (line[j] == 'F') {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) count++
            }
        }
    }
    print(count)
}
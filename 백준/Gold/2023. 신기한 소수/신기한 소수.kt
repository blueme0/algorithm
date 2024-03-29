import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

var N = 0
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt() - 1

    if (N == 0) bw.write("2\n3\n5\n7\n")
    else {
        isSpecial(2, 1)
        isSpecial(3, 1)
        isSpecial(5, 1)
        isSpecial(7, 1)
    }
    bw.flush()
    bw.close()
}

private fun isSpecial(num: Int, size: Int) {
    val ten = num * 10
    for (i in 1 .. 9) {
        val new = ten + i
        var isPrime = true
        for (j in 2..Math.sqrt(new.toDouble()).toInt() + 1) {
            if (new % j == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) {
            if (size < N) {
                isSpecial(new, size + 1)
            }
            else {
                bw.write("$new\n")
            }
        }
    }
}
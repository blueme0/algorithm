import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val M = st.nextToken().toInt()

    val sb = StringBuilder()

    var all = 0
    for (i in 0..19) {
        all = all or (1 shl i)
    }
    var S = 0

    for(i in 1..M) {
        st = StringTokenizer(br.readLine())
        val cmd = st.nextToken()
        if (cmd == "all") {
            S = all
            continue
        }
        if (cmd == "empty") {
            S = 0
            continue
        }
        val num = st.nextToken().toInt() - 1

        when (cmd) {
            "add" -> {
                S = S or (1 shl num)
            }

            "remove" -> {
                S = S and (1 shl num).inv()
            }

            "check" -> {
                if (S and (1 shl num) != 0) sb.appendLine("1")
                else sb.appendLine("0")
            }

            "toggle" -> {
                S = S xor (1 shl num)
            }
        }
    }
    print(sb)
}
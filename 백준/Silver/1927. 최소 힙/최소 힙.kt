import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val tm = TreeMap<Int, Int>()
    val sb = StringBuilder()

    repeat(N) {
        val x = br.readLine().toInt()

        when (x) {
            0 -> {
                if (tm.isEmpty()) sb.appendLine(0)
                else {
                    val fk = tm.firstKey()
                    sb.appendLine(fk)
                    if (tm[fk]!! > 1) tm[fk] = tm[fk]!! - 1
                    else tm.remove(fk)
                }
            }
            else -> {
                if (tm.contains(x)) tm[x] = tm[x]!! + 1
                else tm[x] = 1
            }
        }
    }
    print(sb)
}
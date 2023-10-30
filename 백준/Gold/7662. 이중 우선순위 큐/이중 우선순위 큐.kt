import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(T) {
        val tm = TreeMap<Int, Int>()
        val k = br.readLine().toInt()
        repeat(k) {
            val (cmd, num) = br.readLine().split(" ")
            if (cmd == "I") {
                tm[num.toInt()] = tm.getOrDefault(num.toInt(), 0) + 1
            }
            if (cmd == "D" && tm.isNotEmpty()) {
                val key = if (num == "-1") tm.firstKey() else tm.lastKey()
                val keyCnt = tm[key]
                if (keyCnt == 1) tm.remove(key)
                else tm[key] = keyCnt!! - 1
            }
        }
        if (tm.size == 0) sb.appendLine("EMPTY")
        else sb.appendLine("${tm.lastKey()} ${tm.firstKey()}")
    }
    print(sb)
}
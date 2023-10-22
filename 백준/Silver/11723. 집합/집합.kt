import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val M = br.readLine().toInt()

    var S = mutableSetOf<Int>()
    val sb = StringBuilder()
    repeat(M) {
        val cmd = br.readLine().split(" ")
        when (cmd[0]) {
            "add" -> {
                if (!S.contains(cmd[1].toInt())) S.add(cmd[1].toInt())
            }
            "remove" -> {
                if (S.contains(cmd[1].toInt())) S.remove(cmd[1].toInt())
            }
            "check" -> {
                if (S.contains(cmd[1].toInt())) sb.appendLine(1)
                else sb.appendLine(0)
            }
            "toggle" -> {
                if (S.contains(cmd[1].toInt())) S.remove(cmd[1].toInt())
                else S.add(cmd[1].toInt())
            }
            "all" -> {
                S = (1..20).toMutableSet()
            }
            "empty" -> {
                S = mutableSetOf()
            }
        }
    }
    print(sb)
}
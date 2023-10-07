import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val map = TreeMap<String, Int>()

    var cnt = 0
    while (true) {
        val str = br.readLine() ?: break

        if (map.containsKey(str)) {
            map[str] = map[str]!! + 1
        }
        else {
            map[str] = 1
        }
        cnt++
    }

    for (type in map) {
        println("${type.key} ${String.format("%.4f", 100.0 * type.value / cnt)}")
    }

}
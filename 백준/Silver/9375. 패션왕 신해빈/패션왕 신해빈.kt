import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = HashMap<String, Int>()
    val sb = StringBuilder()

    val T = br.readLine().toInt()
    repeat(T) {
        map.clear()
        val N = br.readLine().toInt()
        repeat(N) {
            val (_, type) = br.readLine().split(" ")
            if (map.containsKey(type)) map[type] = map[type]!! + 1
            else map[type] = 2
        }
        var result = 1
        for (v in map.values) {
            result *= v
        }
        sb.appendLine(result - 1)
    }
    print(sb)
}
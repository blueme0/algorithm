import java.lang.StringBuilder
import java.util.TreeSet

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val heard = TreeSet<String>()
    val seen = TreeSet<String>()

    val sb = StringBuilder()

    repeat(N) {
        heard.add(br.readLine())
    }
    repeat(M){
        val name = br.readLine()
        if (heard.contains(name)) {
            seen.add(name)
        }
    }
    sb.appendLine(seen.size)
    for (n in seen) {
        sb.appendLine(n)
    }
    print(sb)

}
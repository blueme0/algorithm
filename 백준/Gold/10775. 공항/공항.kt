import java.io.BufferedReader
import java.io.InputStreamReader

var G = 0
var P = 0
var dock = arrayOf<Int>()
var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    G = br.readLine().toInt()
    P = br.readLine().toInt()

    dock = Array<Int>(G + 1) { 0 }
    for (i in 1..G) dock[i] = i

    for (i in 0 until P) {
        val cur = br.readLine().toInt()
        if (cur == dock[cur]) {
            cnt++
            dock[cur] = findParent(cur - 1)
        } else {
            val parent = findParent(dock[cur])
            if (parent == 0) break
            cnt++
            dock[parent] = dock[parent - 1]
        }
    }

    print(cnt)
}

fun findParent(idx: Int): Int {
    if (idx == dock[idx]) return idx
    if (idx == 0) return 0
    dock[idx] = findParent(dock[idx])
    return dock[idx]
}
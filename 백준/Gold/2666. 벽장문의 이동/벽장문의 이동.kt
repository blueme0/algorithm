import java.io.BufferedReader
import java.io.InputStreamReader

var door = IntArray(0)
var k = 0
var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val (one, two) = br.readLine().split(" ").map { it.toInt() }

    k = br.readLine().toInt()

    door = IntArray(k) { 0 }
    for (i in 0 until k) door[i] = br.readLine().toInt()
    if (one < two) find(0, 0, one, two) else find(0, 0, two, one)
    print(min)

}

fun find(cur: Int, cnt: Int, first: Int, second: Int) {
    if (cur >= k) {
        min = Math.min(min, cnt)
        return
    }
    if (door[cur] == first || door[cur] == second) {
        find(cur + 1, cnt, first, second)
        return
    }
    if (door[cur] < first) {
        find(cur + 1, cnt + first - door[cur], door[cur], second)
        return
    }
    if (door[cur] > second) {
        find(cur + 1, cnt + door[cur] - second, first, door[cur])
        return
    }
    find(cur + 1, cnt + door[cur] - first, door[cur], second)
    find(cur + 1, cnt + second - door[cur], first, door[cur])
}
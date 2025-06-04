import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val map = IntArray(101) { it }

    repeat(N + M) {
        st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        map[x] = y
    }

    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(1, 0))
    val visited = BooleanArray(101)
    visited[1] = true
    var arrived = -1

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (i in 1..6) {
            if (cur.first + i > 100) {
                break
            } else if (map[cur.first + i] == 100) {
                arrived = cur.second + 1
                break
            } else if (!visited[map[cur.first + i]]) {
                visited[map[cur.first + i]] = true
                queue.offer(Pair(map[cur.first + i], cur.second + 1))
            }
        }

        if (arrived > 0) break
    }

    print(arrived)
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var K = 0
var limit = 0
var visited = BooleanArray(0)
var depth = Array<Int>(0) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nums = br.readLine().split(" ").map { it.toInt() }
    N = nums[0]
    K = nums[1]

    limit = Math.max(N, K) + 2
    visited = BooleanArray(limit + 1) { false }
    depth = Array<Int>(limit + 1) { 0 }

    val result = BFS(N)
    print(result)
}

private fun BFS(start: Int): Int {
    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true

    var result = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        val x = arrayOf(cur - 1, cur + 1, cur * 2)
        for (i in x) {
            if (i in 0.. limit && i <= 100000) {
                if (!visited[i]) {
                    visited[i] = true
                    queue.add(i)
                    depth[i] = depth[cur] + 1
                    if (i == K) result = depth[i]
                }
            }
        }
        if (result > 0) break
    }

    return result
}
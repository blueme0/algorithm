import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

var N = 0
var K = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    N = cmd[0]
    K = cmd[1]
    var result = 0
    val visited = BooleanArray(200_001) { false }

    val pq = PriorityQueue<Node>()
    pq.add(Node(0, N))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (visited[cur.x]) continue
        visited[cur.x] = true
//        println("cur: ${cur.x}, depth: ${cur.depth}")
        if (cur.x == K) {
            result = cur.depth
            break
        }

        if (cur.x > K) {
            pq.add(Node(cur.depth + cur.x - K, K))
            continue
        }

        if (cur.x > 1) pq.add(Node(cur.depth + 1, cur.x - 1))
        pq.add(Node(cur.depth + 1, cur.x + 1))
        pq.add(Node(cur.depth, cur.x * 2))

    }
    print(result)
}

data class Node(val depth: Int, val x: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        if (depth != other.depth) return depth - other.depth
        return other.x - x
    }
}
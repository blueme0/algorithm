import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var map = arrayOf<Array<Int>>()
var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()
    map = Array(N) { Array<Int>(N) { 0 } }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    dfs(map, 1)
    print(max)
}

fun up(): Array<Array<Int>> {
    val temp = Array(N) { Array<Int>(N) { 0 } }

    for (x in 0 until N) {
        val queue = LinkedList<Int>()
        for (y in 0 until N) if (map[y][x] != 0) queue.offer(map[y][x])

        var idx = 0
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val next = queue.peek()

            if (cur == next) {
                queue.poll()
                temp[idx][x] = cur * 2

            } else {
                temp[idx][x] = cur
            }
            max = Math.max(max, temp[idx][x])
            idx++
        }
    }

    return temp
}

fun down(): Array<Array<Int>> {
    val temp = Array(N) { Array<Int>(N) { 0 } }

    for (x in 0 until N) {
        val queue = LinkedList<Int>()
        for (y in N - 1 downTo 0) if (map[y][x] != 0) queue.offer(map[y][x])

        var idx = N - 1
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val next = queue.peek()

            if (cur == next) {
                queue.poll()
                temp[idx][x] = cur * 2

            } else {
                temp[idx][x] = cur
            }
            max = Math.max(max, temp[idx][x])
            idx--
        }
    }

    return temp
}

fun left(): Array<Array<Int>> {
    val temp = Array(N) { Array<Int>(N) { 0 } }

    for (y in 0 until N) {
        val queue = LinkedList<Int>()
        for (x in 0 until N) if (map[y][x] != 0) queue.offer(map[y][x])

        var idx = 0
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val next = queue.peek()

            if (cur == next) {
                queue.poll()
                temp[y][idx] = cur * 2

            } else {
                temp[y][idx] = cur
            }
            max = Math.max(max, temp[y][idx])
            idx++
        }
    }

    return temp
}

fun right(): Array<Array<Int>> {
    val temp = Array(N) { Array<Int>(N) { 0 } }

    for (y in 0 until N) {
        val queue = LinkedList<Int>()
        for (x in N - 1 downTo 0) if (map[y][x] != 0) queue.offer(map[y][x])

        var idx = N - 1
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val next = queue.peek()

            if (cur == next) {
                queue.poll()
                temp[y][idx] = cur * 2

            } else {
                temp[y][idx] = cur
            }
            max = Math.max(max, temp[y][idx])
            idx--
        }
    }

    return temp
}

fun dfs(cur: Array<Array<Int>>, depth: Int) {
    if (depth > 5) return

    val temp = Array(N) { Array(N) { 0 } }
    for (i in 0 until N) {
        for (j in 0 until N) {
            temp[i][j] = map[i][j]
        }
    }

    map = cur
    dfs(up(), depth + 1)
    dfs(down(), depth + 1)
    dfs(left(), depth + 1)
    dfs(right(), depth + 1)
    map = temp
}
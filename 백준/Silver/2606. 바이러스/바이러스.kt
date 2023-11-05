var computers = 0
var connections = arrayOf<BooleanArray>()
var visited = booleanArrayOf()
var count = -1

fun main() {
    val br = System.`in`.bufferedReader()
    computers = br.readLine().toInt()
    connections = Array (computers) {BooleanArray(computers) { false } }
    visited = BooleanArray(computers) { false }

    val pairs = br.readLine().toInt()
    repeat(pairs) {
        val (x, y) = br.readLine().split(" ").map{ it.toInt() }
        connections[x - 1][y - 1] = true
        connections[y - 1][x - 1] = true
    }

    dfs(computers, 0)

    print(count)

}

private fun dfs(n: Int, v: Int) {
    if (!visited[v]) {
        visited[v] = true
        count++
    }

    for (i in 0 until n) {
        if (connections[v][i] && !visited[i]) dfs(n, i)
    }
}
import java.util.StringTokenizer

lateinit var visited: Array<Boolean>
lateinit var parents: Array<Int>
val edges: ArrayList<ArrayList<Int>> = ArrayList()


fun main() {
    val br = System.`in`.bufferedReader()
    val nodes = Integer.parseInt(br.readLine())

    for (i in 0 .. nodes) {
        edges.add(ArrayList<Int>())
    }

    for (i in 0 until nodes-1) {
        val st = StringTokenizer(br.readLine(), " ")
        val node1 = Integer.parseInt(st.nextToken())
        val node2 = Integer.parseInt(st.nextToken())

        edges.get(node1).add(node2)
        edges.get(node2).add(node1)
    }

    visited = Array<Boolean>(nodes+1) {false}
    parents = Array<Int>(nodes+1) {0}

    dfs(1)

    for (i in 2 until parents.size) {
        println(parents[i])
    }
}

fun dfs(node: Int) {
    visited[node] = true

    for (v in edges.get(node)) {
        if (!visited[v]) {
            dfs(v)
            parents[v] = node
        }
    }
}
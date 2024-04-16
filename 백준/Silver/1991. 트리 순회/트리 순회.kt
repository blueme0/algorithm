import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var graph = HashMap<Char, Node>()
var preorder = ""
var inorder = ""
var postorder = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()

    repeat(N) {
        st = StringTokenizer(br.readLine())
        val cur = charArrayOf(st.nextToken()[0], st.nextToken()[0], st.nextToken()[0])
        graph[cur[0]] = Node(cur[1], cur[2])
    }
    traversal('A')
    println(preorder)
    println(inorder)
    println(postorder)
}

fun traversal(n: Char) {
    preorder += n
    graph[n]?.prev?.let { if (it != '.') traversal(it) }
    inorder += n
    graph[n]?.next?.let { if (it != '.') traversal(it) }
    postorder += n
}



data class Node(val prev: Char, val next: Char)
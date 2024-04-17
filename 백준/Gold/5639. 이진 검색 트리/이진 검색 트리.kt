import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val root = Node(br.readLine().toInt(), null, null)

    while (true) {
        val cur = br.readLine() ?: break // 입력값이 없으면 break
        if (cur.isBlank()) break
        val n = cur.toInt()
        root.addChild(n)
    }

    postOrder(root)
    print(sb)
}

data class Node(val value: Int, var left: Node?, var right: Node?) {
    fun addChild(n: Int) {
        if (n > value) {
            if (right == null) right = Node(n, null, null)
            else right!!.addChild(n)
        }
        else {
            if (left == null) left = Node(n, null, null)
            else left!!.addChild(n)
        }
    }
}

fun postOrder(node: Node?) {
    if (node != null) {
        postOrder(node.left)
        postOrder(node.right)
        sb.appendLine(node.value)
    }
}
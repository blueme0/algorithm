import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val deq: Deque<Node> = ArrayDeque(n)
    for (i in 0 ..< n) {
        val new = st.nextToken().toInt()
        while (deq.isNotEmpty() && deq.last.value >= new) {
            deq.removeLast()
        }
        deq.addLast(Node(i, new))
        if (deq.first.index < i - l + 1) deq.removeFirst()
        bw.write("${deq.first.value} ")
    }
    bw.flush()
    bw.close()
}

class Node(
    val index: Int,
    val value: Int
)


import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val arr = Array<Int>(N + 1) { 0 }
    val graph = Array(N + 1) { mutableListOf<Int>() }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        arr[end]++
        graph[start].add(end)
    }

    val zeros = LinkedList<Int>()
    for (i in 1..N) if (arr[i] == 0) zeros.offer(i)

    while (zeros.isNotEmpty()) {
        val cur = zeros.poll()
        bw.write("$cur ")

        for (i in graph[cur]) {
            arr[i]--
            if (arr[i] == 0) zeros.offer(i)
        }
    }

    bw.flush()
    bw.close()
}
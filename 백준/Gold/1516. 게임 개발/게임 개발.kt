import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val prior = Array(N + 1) { ArrayList<Int>() }
    val count = IntArray(N + 1) { 0 }
    val times = IntArray(N + 1) { 0 }
    val answer = IntArray(N + 1) { 0 }
    val zeros = LinkedList<Int>()

    for (i in 1 .. N) {
        st = StringTokenizer(br.readLine())
        times[i] = st.nextToken().toInt()
        while (true) {
            val cur = st.nextToken().toInt()
            if (cur == -1) break
            prior[cur].add(i)
            count[i]++
        }
        if (count[i] == 0) zeros.offer(i)
    }

    while (zeros.isNotEmpty()) {
        val cur = zeros.peek()
        for (i in prior[cur]) {
            count[i]--
            answer[i] = Math.max(answer[i], answer[cur] + times[cur])
            if (count[i] == 0) zeros.offer(i)
        }
        zeros.poll()
    }

    for (i in 1 .. N) {
        bw.write("${answer[i] + times[i]}\n")
    }

    bw.flush()
    bw.close()
}
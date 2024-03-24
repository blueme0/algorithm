import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val nums = IntArray(N + 1) { 0 }
    st = StringTokenizer(br.readLine())
    for (i in 1 ..N) {
        nums[i] = nums[i - 1] + st.nextToken().toInt()
    }

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val sum = nums[end] - nums[start - 1]
        bw.write("$sum\n")
    }

    bw.flush()
    bw.close()
}
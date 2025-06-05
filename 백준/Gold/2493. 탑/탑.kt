import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    st = StringTokenizer(br.readLine())
    val stack = ArrayList<Pair<Int, Int>>() // Pair(high, idx)
    for (i in 0 until N) {
        val high = st.nextToken().toInt()
        while (stack.isNotEmpty() && stack.last().first <= high) {
            stack.removeLast()
        }
        if (stack.isEmpty()) bw.write("0 ")
        else bw.write("${stack.last().second + 1} ")
        stack.add(Pair(high, i))
    }
    bw.flush()
    bw.close()
}
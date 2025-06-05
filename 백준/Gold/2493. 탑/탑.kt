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
        /**
         * 탑 체크.
         */

        var receive = 0
        for (j in stack.size - 1 downTo 0) {
            if (stack[j].first > high) {
                receive = stack[j].second + 1
                break
            }
        }
        bw.write("$receive ")

        while (stack.isNotEmpty() && stack.last().first <= high) {
            stack.removeLast()
        }
        stack.add(Pair(high, i))


        /**
         * 6
         *
         * 6, 9 -> 9, 9로 판단.....
         *
         * 9, 9, 5,
         *
         * 9, 9, 5, 7 -> 9, 9, 7, 7이 되
         *
         */
    }
    bw.flush()
    bw.close()
}
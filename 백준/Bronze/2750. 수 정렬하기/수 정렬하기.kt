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
    val arr = IntArray(N) { 0 }
    for (i in 0 ..< N) {
        st = StringTokenizer(br.readLine())
        arr[i] = st.nextToken().toInt()
    }
    for (i in 0 ..< N - 1) {
        for (j in 0 ..< N - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    for (i in 0 ..< N) {
        bw.write("${arr[i]}\n")
    }
    bw.flush()
    bw.close()
}
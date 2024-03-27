import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    val pq = PriorityQueue<Int>()

    repeat(N) {
        pq.add(br.readLine().toInt())
    }

    repeat(N) {
        bw.write("${pq.poll()}\n")
    }
    bw.flush()
    bw.close()
}
import java.util.*
import java.io.*

fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val pqueue = PriorityQueue<Int>(Collections.reverseOrder())

    for (i in 1..N) {
        val num = br.readLine().toInt()

        if (num != 0) {
            pqueue.offer(num)
        }
        else {
            if (pqueue.isEmpty()) bw.write("0\n")
            else bw.write("${pqueue.poll()}\n")
        }
    }
    bw.flush()
    bw.close()
}
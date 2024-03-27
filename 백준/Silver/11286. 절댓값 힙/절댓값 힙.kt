import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    val pq = PriorityQueue<AbsInt>()

    repeat(N) {
        val cur = br.readLine().toInt()
        if (cur == 0) {
            if (pq.isEmpty()) bw.write("0\n")
            else bw.write("${pq.poll().int}\n")
        } else {
            pq.add(AbsInt(cur))
        }
    }

    bw.flush()
    bw.close()
}

data class AbsInt(val int: Int) : Comparable<AbsInt> {
    override fun compareTo(other: AbsInt): Int {
        return if (abs(int) == abs(other.int)) {
            int - other.int
        } else abs(int) - abs(other.int)
    }
}
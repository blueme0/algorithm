import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()

    val arr = Array<Meeting>(N) { Meeting(0, 0) }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        arr[i] = Meeting(start, end)
    }

    arr.sort()

    var count = 0
    var finished = 0

    for (i in 0 until N) {
        if (arr[i].s >= finished) {
            finished = arr[i].e
            count++
        }
    }

    print(count)
}

data class Meeting(val s: Int, val e: Int) : Comparable<Meeting> {
    override fun compareTo(other: Meeting): Int {
        if (e == other.e) return s - other.s
        else return e - other.e
    }
}
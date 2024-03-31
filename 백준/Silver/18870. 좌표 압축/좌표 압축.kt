import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())

    val arr = Array<Point>(N) { Point(0, 0) }

    for (i in 0 until N) {
        val cur = st.nextToken().toInt()
        arr[i] = Point(i, cur)
    }

    arr.sortWith(Comparator { o1, o2 ->
        o1.value - o2.value
    })

    var prev = arr[0].value
    var index = 0
    arr[0].value = index

    for (i in 1 until N) {
        if (prev != arr[i].value) {
            index++
            prev = arr[i].value
        }
        arr[i].value = index
    }

    arr.sortWith(Comparator { o1, o2 ->
        o1.index - o2.index
    })

    for (i in 0 until N) {
        bw.write("${arr[i].value} ")
    }

    bw.flush()
    bw.close()
}

data class Point(val index: Int, var value: Int)
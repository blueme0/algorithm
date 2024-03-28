import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var arr = arrayOf<Int>()
var tmp = arrayOf<Int>()
var count: Long = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())

    arr = Array<Int>(N + 1) { 0 }
    tmp = Array<Int>(N + 1) { 0 }

    for (i in 1 .. N) {
        arr[i] = st.nextToken().toInt()
    }

    mergeSort(1, N)
    print(count)
}

private fun mergeSort(s: Int, e: Int) {
    if (e - s < 1) return
    val m = s + (e - s) / 2
    mergeSort(s, m)
    mergeSort(m + 1, e)

    for (i in s .. e) {
        tmp[i] = arr[i]
    }
    var k = s
    var index1 = s
    var index2 = m + 1

    while (index1 <= m && index2 <= e) {
        if (tmp[index1] > tmp[index2]) {
            arr[k] = tmp[index2]
            count = count + index2 - k
            k++
            index2++
        } else {
            arr[k] = tmp[index1]
            k++
            index1++
        }
    }

    while (index1 <= m) {
        arr[k] = tmp[index1]
        k++
        index1++
    }
    while (index2 <= e) {
        arr[k] = tmp[index2]
        k++
        index2++
    }
}

import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
val list = ArrayList<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    val ai = br.readLine().split(" ").map { it.toInt() }

    for (i in ai) {
        if (list.isEmpty() || list.last() < i) {
            list.add(i)
            continue
        }
        val change = binarySearch(i)
        list[change] = i
    }
    print(list.size)
}

fun binarySearch(num: Int): Int {
    var left = 0
    var right = list.size - 1

    while (left < right) {
        val mid = (left + right) / 2
        val cur = list[mid];
        if (num > cur) {
            left = mid + 1
        } else if (num < cur) {
            right = mid
        } else {
            return mid
        }
    }
    return right
}
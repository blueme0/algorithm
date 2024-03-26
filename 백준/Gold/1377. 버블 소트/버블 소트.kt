import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val arr = ArrayList<Info>()
    for (i in 0 until N) {
        arr.add(Info(i, br.readLine().toInt()))
    }

    val sortedArr = arr.sorted()

    var max = 0

    for (i in 0 until N) {
        max = Math.max(max, sortedArr[i].index - i)
    }

    print(max + 1)
}

data class Info(val index: Int, val value: Int)
    : Comparable<Info> {
    override fun compareTo(other: Info): Int {
        return value - other.value
    }
    }
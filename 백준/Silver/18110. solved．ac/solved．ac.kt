import java.util.*
import kotlin.math.roundToInt

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val cut = (n * 0.15).roundToInt()
    val arr = LinkedList<Int>()
    repeat(n) {
        arr.add(br.readLine().toInt())
    }
    arr.sort()

    repeat(cut) {
        arr.pollLast()
        arr.pollFirst()
    }

    if (n == 0) print("0")
    else print(arr.average().roundToInt())

}
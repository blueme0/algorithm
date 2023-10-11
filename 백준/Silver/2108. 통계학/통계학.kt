import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.math.roundToLong

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val nums = mutableListOf<Int>()

    var sum = 0
    val times = HashMap<Int, Int>()

    repeat(N) {
        val line = br.readLine().toInt()
        nums.add(line)
        sum += line
        if (times.containsKey(line)) {
            times[line] = times[line]!! + 1
        }
        else times[line] = 1
    }

    val sortedNums = nums.sorted()

    println(nums.average().roundToInt())
    println(sortedNums[N / 2])

    val maxFrequency = times.values.max()
    val mfList = times.filterValues { it == maxFrequency }.keys.sorted()
    if (mfList.size > 1) {
        println(mfList[1])
    }
    else {
        println(mfList[0])
    }
    println(sortedNums[N - 1] - sortedNums[0])
}
import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()

    val arr = br.readLine().split(" ")
    val N = arr[0].toCharArray().reversedArray()
    val B = arr[1].toInt()

    var result = 0
    for (i in N.indices) {
        if (N[i].isDigit()) {
            result += (N[i] - '0') * B.toDouble().pow(i.toDouble()).toInt()
        }
        else {
            result += (N[i] - ('A' - 10)) * B.toDouble().pow(i.toDouble()).toInt()
        }
    }
    println(result)

}
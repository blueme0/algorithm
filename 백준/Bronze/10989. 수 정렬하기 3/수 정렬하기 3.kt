import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val sb = StringBuilder()
    val arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = br.readLine().toInt()
    }
    arr.sort()
    for (i in 0 until N) {
        sb.appendLine(arr[i])
    }
    print(sb)
}
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val material = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    material.sort()

    var start = 0
    var end = N - 1
    var count = 0

    while (start < end) {
        val sum = material[start] + material[end]
        if (sum < M) {
            start++
        } else if (sum > M) {
            end--
        } else {
            count++
            start++
            end--
        }
    }

    print(count)
}
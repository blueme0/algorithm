import java.io.BufferedReader
import java.io.InputStreamReader

var times = mutableMapOf<Char, Int>()
var min = IntArray(4) { 0 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (S, P) = br.readLine().split(" ").map { it.toInt() }
    val str = br.readLine()
    // A, C, G, T 순서로 최소 개수 저장
    min = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var start = 0
    var end = P - 1
    var count = 0

    times['A'] = 0
    times['C'] = 0
    times['G'] = 0
    times['T'] = 0

    for (i in start until end) {
        times[str[i]] = times[str[i]]!! + 1
    }

    while (end < S) {
        times[str[end]] = times[str[end]]!! + 1
        if (check()) count++
        times[str[start]] = times[str[start]]!! - 1
        start++
        end++
    }

    print(count)

}

fun check(): Boolean {
    return (times['A']!! >= min[0]) && (times['C']!! >= min[1]) && (times['G']!! >= min[2]) && (times['T']!! >= min[3])
}
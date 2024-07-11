import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val liquid = br.readLine().split(" ").map { it.toInt() }

    var start = 0
    var end = N - 1
    var ans = Pair<Int, Int>(start, end)

    while (start < end) {
        val cur = liquid[start] + liquid[end]
        if (Math.abs(cur) <= Math.abs(liquid[ans.first] + liquid[ans.second]))
            ans = Pair(start, end)
        if (cur > 0) end--
        else if (cur < 0) start++
        else break
    }

    print("${liquid[ans.first]} ${liquid[ans.second]}")
}
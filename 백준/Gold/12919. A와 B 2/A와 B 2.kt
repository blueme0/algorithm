import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

var first = ""
var second = ""
var len = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    first = br.readLine()
    second = br.readLine()
    len = first.length

    val answer = dfs(false, 0, second.length - 1)
    if (answer) print(1) else print(0)
}

fun dfs(isReversed: Boolean, start: Int, end: Int): Boolean {
    if (len == (end - start + 1)) {
        var answer = second.substring(start, end + 1)
        if (isReversed) answer = answer.reversed()
        return if (answer == first) true else false 
    }
    
    var available = false
    
    if (!isReversed) {
        if (second[end] == 'A') available = dfs(false, start, end - 1)
        if (second[start] == 'B') available = available || dfs(true, start + 1, end)
    } else {
        if (second[start] == 'A') available = dfs(true, start + 1, end)
        if (second[end] == 'B') available = available || dfs(false, start, end - 1)
    }
    
    return available
}
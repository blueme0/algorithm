import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val S = br.readLine()
    val T = br.readLine()

    var start = 0
    var end = T.length - 1
    var isReversed = false
    val trial = T.length - S.length

    repeat(trial) {
        if (isReversed) {
            if (T[start] == 'B') isReversed = false
            start++
        } else {
            if (T[end] == 'B') isReversed = true
            end--
        }
    }

    var answer = T.substring(start, end + 1)
    if (isReversed) answer = answer.reversed()
    if (S.equals(answer)) print(1) else print(0)
}
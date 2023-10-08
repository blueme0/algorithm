import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val test = br.readLine().toCharArray()
    var result = 0
    var now = 0
    for (i in 0 until test.size) {
        if (test[i] == '(') {
            now++
        }
        else if (test[i] == ')') {
            now -= 1
            if (test[i - 1] == '(') {
                result += now
            }
            else {
                result += 1
            }
        }
    }
    print(result)
}
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine().toCharArray()

    var answer = 0
    var temp = 1
    val stack = LinkedList<Char>()

    for (i in 0 until str.size) {
        when (str[i]) {
            '(' -> {
                temp *= 2
                stack.offerLast('(')
            }
            ')' -> {
                if (stack.isEmpty() || stack.peekLast() != '(') {
                    answer = 0
                    break
                }
                if (str[i - 1] == '(') {
                    answer += temp
                }
                temp /= 2
                stack.pollLast()
            }
            '[' -> {
                temp *= 3
                stack.offerLast('[')
            }
            ']' -> {
                if (stack.isEmpty() || stack.peekLast() != '[') {
                    answer = 0
                    break
                }
                if (str[i - 1] == '[') {
                    answer += temp
                }
                temp /= 3
                stack.pollLast()
            }
        }
    }

    if (stack.isNotEmpty()) answer = 0
    println(answer)
}
import java.io.BufferedReader
import java.io.InputStreamReader

var expression = ""
var result = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    expression = br.readLine()

    postfix()
    print(result)
}

fun postfix() {
    val stack = mutableListOf<Char>()
    for (a in expression) {
        when (a) {
            '+' -> {
                while (stack.isNotEmpty() && stack.last() != '(') {
                    result += stack.removeLast()
                }
                stack.add(a)
            }
            '-' -> {
                while (stack.isNotEmpty() && stack.last() != '(') {
                    result += stack.removeLast()
                }
                stack.add(a)
            }
            '*' -> {
                while (stack.isNotEmpty() && (stack.last() == '*' || stack.last() == '/')) {
                    result += stack.removeLast()
                }
                stack.add(a)
            }
            '/' -> {
                while (stack.isNotEmpty() && (stack.last() == '*' || stack.last() == '/')) {
                    result += stack.removeLast()
                }
                stack.add(a)
            }
            '(' -> stack.add(a)
            ')' -> {
                while (stack.last() != '(') {
                    result += stack.removeLast()
                }
                stack.removeLast()
            }
            else -> {
                result += a
            }
        }
    }
    while (stack.isNotEmpty()) {
        result += stack.removeLast()
    }
}
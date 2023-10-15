import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    while (true) {
        val line = br.readLine()
        if (line == ".") break
        val stack = mutableListOf<Char>()
        var result = true
        for (a in line) {
            if (a == '.') {
                if (stack.isNotEmpty()) result = false
                break
            }
            if (a == '[' || a == '(') stack.add(a)
            if (a == ']' && (stack.size <= 0 || stack.removeLast() != '[')) {
                result = false
                break
            }
            if (a == ')' && (stack.size <= 0 || stack.removeLast() != '(')) {
                result = false
                break
            }
        }
        if (result) sb.append("yes\n") else sb.append("no\n")
    }
    println(sb)
}
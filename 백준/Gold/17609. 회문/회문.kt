import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val str = br.readLine()
        sb.appendLine(isPalindrome(str, 0, str.length - 1, false))
    }
    print(sb)
}

fun isPalindrome(str: String, l: Int, r: Int, isPseudo: Boolean): Int {
    var left = l
    var right = r
    while (left < right) {
        if (str[left] != str[right]) {
            if (!isPseudo) {
                if (isPalindrome(str, left + 1, right, true) == 0 || isPalindrome(str, left, right - 1, true) == 0) return 1
            }
            return 2
        }
        left++
        right--
    }
    return 0
}
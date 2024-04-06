import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val max = 1003001

    // 1,000,000 직후의 팰린드롬 수 : 1003001

    val isPrime = BooleanArray(max + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..max) {
        if (isPrime[i]) {
            for (j in i * 2 .. max step i) {
                isPrime[j] = false
            }
        }
    }

    for (i in N..max) {
        if (isPrime[i]) {
            val str = i.toString()
            val stack = mutableListOf<Char>()
            var isAvailable = true
            if (str.length % 2 == 0) {
                for (j in 0 until str.length / 2) {
                    stack.add(str[j])
                }
                for (j in str.length / 2 until str.length) {
                    if (stack.removeLast() != str[j]) {
                        isAvailable = false
                        break
                    }
                }
            } else {
                for (j in 0 until str.length / 2) {
                    stack.add(str[j])
                }
                for (j in str.length / 2 + 1 until str.length) {
                    if (stack.removeLast() != str[j]) {
                        isAvailable = false
                        break
                    }
                }
            }
            if (isAvailable) {
                println(i)
                break
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toLong() }
    val sb = StringBuilder()
    var A = 0L;
    var B = 0L;
    // A < B
    if (cmd[0] > cmd[1]) {
        A = cmd[1]
        B = cmd[0]
    } else {
        A = cmd[0]
        B = cmd[1]
    }

    var rest = 0L
    while (A != 0L) {
        rest = B % A
        B = A
        A = rest
    }

    var gcd = B.toInt()
    repeat(gcd) {
        sb.append(1)
    }

    print(sb)
}
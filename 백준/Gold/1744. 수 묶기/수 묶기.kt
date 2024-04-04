import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var zeros = 0
    val positive = PriorityQueue<Int>(reverseOrder())
    val negative = PriorityQueue<Int>()

    var result = 0L

    repeat(N) {
        val num = br.readLine().toInt()
        if (num > 1) positive.add(num)
        else if (num < 0) negative.add(num)
        else if (num == 1) result++
        else zeros++
    }

    /**
     * 양수 -> 일단 다 곱해 큰 것부터 두개씩
     * 음수 ->
     *  음수가 짝수개면 -> 서로 곱해서 더해
     *  음수가 홀수개면
     *      0이 있어 -> 제일 작은거 하나 남겨두고 0이랑 곱해
     *      0이 없어 -> 제일 작은거 하나 남겨두고 더해
     */

    while (positive.size > 1) {
        result += positive.poll() * positive.poll()
    }
    if (positive.isNotEmpty()) result += positive.poll()

    if (negative.size % 2 == 0) {
        while (negative.isNotEmpty()) {
            result += negative.poll() * negative.poll()
        }
    } else {
        while (negative.size > 1) {
            result += negative.poll() * negative.poll()
        }
        if (zeros == 0) result += negative.poll()
    }

    print(result)
}
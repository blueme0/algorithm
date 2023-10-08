import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    val cmd = br.readLine().toCharArray()
    val queue = LinkedList<Double>()
    val numbers = mutableListOf<Int>()
    repeat(N) {
        numbers.add(br.readLine().toInt())
    }
    for (i in cmd.indices) {
        when (cmd[i]) {
            '+' -> {
                queue.offerLast(queue.pollLast() + queue.pollLast())
            }
            '-' -> {
                val sub = queue.pollLast()
                queue.offerLast(queue.pollLast() - sub)
            }
            '*' -> {
                queue.offerLast(queue.pollLast() * queue.pollLast())
            }
            '/' -> {
                val div = queue.pollLast()
                queue.offerLast(queue.pollLast() / div)
            }
            else -> {
                queue.offerLast(numbers[cmd[i] - 'A'].toDouble())
            }
        }
    }
    print(String.format("%.2f", queue.poll()))
}
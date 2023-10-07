import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val queue = LinkedList<Int>()
    val N = br.readLine().toInt()

    repeat(N) {
        val cmd = br.readLine().split(" ")
        when (cmd[0]) {
            "push" -> {
                queue.offer(cmd[1].toInt())
            }
            "pop" -> {
                if (queue.isEmpty()) println(-1)
                else println(queue.poll())
            }
            "size" -> {
                println(queue.size)
            }
            "empty" -> {
                if (queue.isEmpty()) println(1) else println(0)
            }
            "front" -> {
                if (queue.isEmpty()) println(-1)
                else println(queue.peekFirst())
            }
            "back" -> {
                if (queue.isEmpty()) println(-1)
                else println(queue.peekLast())
            }
        }
    }
}
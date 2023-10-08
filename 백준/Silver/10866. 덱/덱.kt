import kotlin.collections.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()

    val deque = ArrayDeque<Int>()
    repeat(N) {
        val cmd = br.readLine().split(" ")
        when (cmd[0]) {
            "push_back" -> deque.addLast(cmd[1].toInt())
            "push_front" -> deque.addFirst(cmd[1].toInt())
            "pop_front" -> {
                if (deque.isEmpty()) println(-1)
                else println(deque.removeFirst())
            }
            "pop_back" -> {
                if (deque.isEmpty()) println(-1)
                else println(deque.removeLast())
            }
            "size" -> println(deque.size)
            "empty" -> {
                if (deque.isEmpty()) println(1)
                else println(0)
            }
            "front" -> {
                if (deque.isEmpty()) println(-1)
                else println(deque.first())
            }
            "back" -> {
                if (deque.isEmpty()) println(-1)
                else println(deque.last())
            }
        }
    }
}
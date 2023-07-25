import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val docs = br.readLine().toInt()

    repeat(docs) {
        val cmd = br.readLine().split(" ")
        val N = cmd[0].toInt()
        val M = cmd[1].toInt()

        val queue = LinkedList<Int>(br.readLine().split(" ").map { it.toInt()} )
        val queue_index = LinkedList<Int>((0 until N).toList())

        var cnt = 1
        while (true) {
            if (queue.max() == queue.peekFirst()) {
                if (queue_index.peekFirst() == M) {
                    println(cnt)
                    break
                }
                else {
                    queue.removeFirst()
                    queue_index.removeFirst()
                    cnt++
                }
            }
            else {
                Collections.rotate(queue, -1)
                Collections.rotate(queue_index, -1)
            }
        }
    }
}
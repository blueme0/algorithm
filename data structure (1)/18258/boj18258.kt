fun main() {
    val br = System.`in`.bufferedReader().readText()
    val lines = br.lines()
    val N = lines[0].toInt()
    val queue = ArrayDeque<Int>()

    val sb = StringBuilder()

    for (i in 1..N) {
        val cmd = lines[i].split(" ")
        when (cmd[0]) {
            "push" -> queue.addLast(cmd[1].toInt())
            "pop" -> {
                if (queue.isEmpty()) sb.appendLine(-1)
                else sb.appendLine(queue.removeFirst())
            }
            "size" -> sb.appendLine(queue.size)
            "empty" -> {
                if (queue.isEmpty()) sb.appendLine(1)
                else sb.appendLine(0)
            }
            "front" -> {
                if (queue.isEmpty()) sb.appendLine(-1)
                else sb.appendLine(queue.first())
            }
            "back" -> {
                if (queue.isEmpty()) sb.appendLine(-1)
                else sb.appendLine(queue.last())
            }
        }
    }
    print(sb.toString())
}
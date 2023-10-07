fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val stack = mutableListOf<Int>()

    val aim = (N downTo 1).toMutableList()

    val sb = StringBuilder()

    for (i in 1..N) {
        val now = br.readLine().toInt()
        while (aim.isNotEmpty() && aim.last() <= now) {
            stack.add(aim.removeLast())
            sb.appendLine("+")
        }
        if (stack.last() == now) {
            stack.removeLast()
            sb.appendLine("-")
        }
        else {
            sb.clear()
            sb.append("NO")
            break
        }
    }
    print(sb.toString())
}
fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val nSet = br.readLine().split(" ").map { it.toInt() }.toMutableSet()
    val M = br.readLine().toInt()
    val mList = br.readLine().split(" ").map { it.toInt() }

    val sb = StringBuilder()
    for (i in mList) {
        if (nSet.contains(i)) sb.appendLine(1)
        else sb.appendLine(0)
    }
    print(sb.toString())
}
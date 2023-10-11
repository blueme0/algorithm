import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val NArr = br.readLine().split(" ").map { it.toInt() }
    val M = br.readLine().toInt()

    val hm = HashMap<Int, Int>()
    val MArr = br.readLine().split(" ").map { it.toInt() }
    for (i in MArr) {
        hm[i] = 0
    }

    for (i in NArr) {
        if (hm.containsKey(i)) hm[i] = hm.getValue(i) + 1
    }

    val sb = StringBuilder()
    for (i in MArr) {
        if (hm[i] == null) sb.append("0 ")
        else sb.append(hm[i].toString() + " ")
    }
    print(sb)
}
import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val arr = ArrayList<Point>()
    val sb = StringBuilder()
    repeat(N) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Point(x, y))
    }
    arr.sortWith(Comparator { o1, o2 ->
        if (o1.y == o2.y) o1.x - o2.x
        else o1.y - o2.y
    })
    for (p in arr) {
        sb.appendLine("${p.x} ${p.y}")
    }

    print(sb)

}

data class Point(val x: Int, val y: Int)
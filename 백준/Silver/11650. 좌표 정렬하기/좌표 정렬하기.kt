fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    val list = mutableListOf<Point>()
    repeat(N) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        list.add(Point(x, y))
    }
    val sorted = list.sortedWith(Comparator { o1, o2 ->
        if (o1.x == o2.x)
            o1.y - o2.y
        else
            o1.x - o2.x
    })

    for (p in sorted) {
        println(p.x.toString() + " " + p.y.toString())
    }
}

data class Point(val x: Int, val y: Int)
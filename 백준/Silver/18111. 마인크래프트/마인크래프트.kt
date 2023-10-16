fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M, B) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N){ IntArray(M) }
    var max = -1
    var min = 257
    var shortest = Int.MAX_VALUE
    var height = 0

    for (i in 0 until N) {
        val line = br.readLine().split(" ").map { it.toInt() }

        for (j in line.indices) {
            map[i][j] = line.get(j)
            min = min.coerceAtMost(map[i][j])
            max = max.coerceAtLeast(map[i][j])
        }
    }

    for (h in min..max) {
        var inventory = B
        var time = 0

        for (i in 0 until N) {
            for (j in 0 until M) {
                var diff = map[i][j] - h
                if (diff > 0) {
                    time += 2 * diff
                    inventory += diff
                }
                else if (diff < 0) {
                    time += -diff
                    inventory -= -diff
                }
            }
        }

        if (inventory >= 0) {
            if (time <= shortest) {
                shortest = time
                height = h
            }
        }
    }

    print("$shortest $height")


}
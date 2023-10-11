fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val nums = br.readLine().split(" ").map { it.toInt() }

    var total = 0

    for (x in 0 until N) {
        for (y in (x + 1) until N) {
            for (z in (y + 1) until N) {
                val temp = nums[x] + nums[y] + nums[z]
                if (temp in (total + 1)..M) {
                    total = temp
                }
                if (total == M) break
            }
            if (total == M) break
        }
        if (total == M) break
    }
    print(total)
}
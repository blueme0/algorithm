fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()

    var count = 0
    for (i in 5..N) {
        var now = i
        while (true) {
            if (now % 5 == 0) {
                count++
                now /= 5
            }
            else break
        }
    }
    println(count)
}

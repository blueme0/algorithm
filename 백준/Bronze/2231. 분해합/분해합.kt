fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val length = N.toString().length
    var result = 0

    for (i in (N-length*9)..N) {
        var now = i
        var total = 0
        while (now > 0) {
            total += now % 10
            now /= 10
        }
        if (i + total == N) {
            result = i
            break
        }
    }
    println(result)
}
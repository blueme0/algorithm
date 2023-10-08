fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    var times = 0
    var now = N
    while (true) {
        now = (now % 10) * 10 + (now % 10 + now / 10) % 10
        times++
        if (N == now) break
    }
    print(times)
}
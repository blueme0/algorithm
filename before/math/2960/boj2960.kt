fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    var now = 1
    val set = mutableSetOf<Int>().apply { addAll(2..N) }

    var result = 0
    var i = 1
    var P = 2
    while (true) {
        if (i * P > N) {
            P = set.min()
            i = 1
        }
        if (set.contains(P * i)) {
            if (now == K) {
                result = P * i
                break
            }
            set.remove(P * i)
            now++
        }
        i++
    }
    print(result)
}
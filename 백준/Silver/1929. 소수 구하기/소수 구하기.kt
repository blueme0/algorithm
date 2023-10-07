fun main() {
    val br = System.`in`.bufferedReader()
    val (M, N) = br.readLine().split(" ").map { it.toInt() }

    val prime = BooleanArray(N + 1) { true }
    prime[0] = false
    prime[1] = false

    for (i in 2..N) {
        if (prime[i]) {
            for (j in i * 2..N step i) {
                prime[j] = false
            }
        }
    }

    val sb = StringBuilder()
    for (i in M..N) {
        if (prime[i]) sb.appendLine(i)
    }
    print(sb.toString())
}

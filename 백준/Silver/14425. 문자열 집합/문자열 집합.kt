fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val set = mutableSetOf<String>()
    var cnt = 0

    repeat(N) {
        set.add(br.readLine())
    }

    repeat(M) {
        if (set.contains(br.readLine()))
            cnt++
    }

    print(cnt)
}
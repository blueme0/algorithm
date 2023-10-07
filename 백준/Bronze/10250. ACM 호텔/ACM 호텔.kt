fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()

    repeat(T) {
        val (H, W, N) = br.readLine().split(" ").map { it.toInt() }
        var result = 0
        result += N / H + 1
        result += (N % H) * 100
        if (N % H == 0) result += H * 100 - 1
        println(result)
    }
}
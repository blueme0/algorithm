fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()
    var div = 2
    while (true) {
        if (N == 1 || N < div) break
        if (N % div == 0) {
            N /= div
            println(div)
            div = 2
        }
        else div++
    }
}
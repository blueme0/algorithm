var N = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().split(" ")
    N = input[0].toInt()

    val r = input[1].toInt()
    val c = input[2].toInt()
    print(find2(r, c))

}

fun find2(r: Int, c: Int): Int {
    var cnt: Int = 0
    var nowR = r
    var nowC = c
    var half = Math.pow(2.0, N.toDouble()).toInt()
    var nextpow = half * half
    while (true) {
        half /= 2
        nextpow /= 4
        if (nowC == 0 && nowR == 0) break
        if (half == 1) {
            cnt += 2 * nowR + nowC
            break
        }
        if (nowC < half) {
            if (nowR < half) {
                // 제 2사분면
                cnt += 0
            }
            else {
                // 제 3사분면
                cnt += nextpow * 2
                nowR -= half
            }
        }
        else {
            if (nowR < half) {
                // 제 1사분면
                cnt += nextpow
                nowC -= half
            }
            else {
                // 제 4사분면
                cnt += nextpow * 3
                nowC -= half
                nowR -= half
            }
        }
    }
    return cnt
}

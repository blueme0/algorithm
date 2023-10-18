fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()
    val zero = IntArray(41){ 0 }
    val one = IntArray(41){ 0 }

    zero[0] = 1
    one[1] = 1

    for (i in 2..40) {
        zero[i] = zero[i-1] + zero[i-2]
        one[i] = one[i-1] + one[i-2]
    }

    repeat(T) {
        val now = br.readLine().toInt()
        println("${zero[now]} ${one[now]}")
    }
}

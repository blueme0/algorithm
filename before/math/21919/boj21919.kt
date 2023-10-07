fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map{ it.toInt() }
    var mul: Long = 1

    val max = arr.max()
    val isPrime = Array<Boolean>(max + 1) { true }
    // 0, 1 are not Prime
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..Math.sqrt(max.toDouble()).toInt() + 1) {
        if (isPrime[i]) {
            for (j in i * i..max step +i) {
                isPrime[j] = false
            }
        }
    }

    // 원래 문제가 최소공배수를 구하는 것이기 때문에 중복 체크도 필요
    for (num in arr) {
        if (isPrime[num] && (mul % num.toLong()).toInt() != 0) mul *= num.toLong()
    }

    if (mul == 1.toLong()) mul = -1
    println(mul)

}
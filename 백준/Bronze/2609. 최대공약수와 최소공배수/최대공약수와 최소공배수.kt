fun main() {
    val br = System.`in`.bufferedReader()
    val num = br.readLine().split(" ").map { it.toInt() }
    var A = 0
    var B = 0
    if (num[0] > num[1]) {
        A = num[1]
        B = num[0]
    }
    else {
        A = num[0]
        B = num[1]
    }

    // 첫째 줄 최대공약수, 둘째 줄 최소공배수
    var gcd = 1
    var div = 2
    while (true) {
        if (A == 1 || div > A) break
        if (A % div == 0 && B % div == 0) {
            A /= div
            B /= div
            gcd *= div
            div = 2
        }
        else div++
    }

    print("$gcd\n${gcd * A * B}")
}
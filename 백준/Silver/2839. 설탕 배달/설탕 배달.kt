fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    var five = N / 5
    var three = 0
    var rest = N % 5

    var result = 0

    if (rest != 0) {
        while (rest % 3 != 0) {
            rest += 5
            five--
            if (five < 0) {
                result = -1
                break
            }
        }
        if (result != -1) result = five + rest / 3
    }
    else {
        result = five
    }
    println(result)
}
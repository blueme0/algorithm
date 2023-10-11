fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    var number = 666
    var count = 1

    while (count != N) {
        number++
        if (number.toString().contains("666")) {
            count++
        }
    }

    println(number)
}
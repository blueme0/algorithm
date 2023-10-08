
fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    repeat(N) {
        var num = br.readLine().toBigInteger()
        if (num.isProbablePrime(100)) {
            println(num)
        }
        else {
            println(num.nextProbablePrime())
        }
    }
}
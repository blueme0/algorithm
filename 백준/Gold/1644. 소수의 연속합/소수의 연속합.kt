import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val NL = N.toLong()

    val isPrime = BooleanArray(N + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..N) {
        if (isPrime[i]) {
            for (j in i * 2..N step i) {
                isPrime[j] = false
            }
        }
    }

    val primes = ArrayList<Long>()
    primes.add(0)
    var sum = 0L
    var cnt = 0
    for (i in 2..N) {
        if (isPrime[i]) {
            sum += i
            primes.add(sum)
            cnt++
        }
    }

    var start = 0
    var end = 0
    var result = 0
    while (end in start..cnt) {
        val cur = primes[end] - primes[start]
        if (cur < N) {
            end++
        } else {
            if (cur == NL) result++
            start++
        }
    }
    print(result)
}
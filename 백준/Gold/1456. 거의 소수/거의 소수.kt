import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (A, B) = br.readLine().split(" ").map { it.toLong() }

    val N = Math.sqrt(B.toDouble()).toInt() + 1
    val isPrime = BooleanArray(N + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2 .. N) {
        if (isPrime[i]) {
            for (j in i * 2 .. N step i) {
                isPrime[j] = false
            }
        }
    }

    val almost = mutableSetOf<Long>()
    for (i in 0..N) {
        if (isPrime[i]) {
            var idx: Long = i.toLong() * i
            while (idx <= B) {
                if (idx >= A) {
                    almost.add(idx)
                }
                if (idx > 100000000000000L / i) break
                idx *= i
            }
        }
    }

    print(almost.size)
}
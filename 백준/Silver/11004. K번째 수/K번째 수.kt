import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val A = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    A.sort()
    print(A[K - 1])
}
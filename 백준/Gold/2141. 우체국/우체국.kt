import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val town = ArrayList<Town>()
    var sum = 0L

    for (i in 1..N) {
        val (x, a) = br.readLine().split(" ").map { it.toInt() }
        town.add(Town(x, a))
        sum += a
    }
    town.sort()

    val mid = (sum + 1) / 2
    var total = 0L

    for (i in 0 until N) {
        total += town[i].a
        if (total >= mid) {
            print(town[i].x)
            break
        }
    }
}

data class Town(val x: Int, val a: Int): Comparable<Town> {
    override fun compareTo(other: Town): Int {
        return x - other.x
    }
}
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val jewels = ArrayList<Jewel>()
    repeat(N) {
        st = StringTokenizer(br.readLine())
        jewels.add(Jewel(st.nextToken().toInt(), st.nextToken().toInt()))
    }
    jewels.sort()

    val bags = ArrayList<Int>()
    repeat(K) {
        st = StringTokenizer(br.readLine())
        bags.add(st.nextToken().toInt())
    }
    bags.sort()

    var total = 0L
    val pq = PriorityQueue<Int>(reverseOrder())
    var jewelIdx = 0

    for (bag in bags) {
        while (jewelIdx < N && jewels[jewelIdx].weight <= bag) {
            pq.add(jewels[jewelIdx].price)
            jewelIdx++
        }
        if (pq.isNotEmpty()) {
            total += pq.poll()
        }
    }

    print(total)
}

data class Jewel(val weight: Int, val price: Int): Comparable<Jewel> {
    override fun compareTo(other: Jewel): Int {
        return weight - other.weight
    }
}
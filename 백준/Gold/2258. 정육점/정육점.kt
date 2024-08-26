import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val pq = PriorityQueue<Meat>()

    repeat(N) {
        st = StringTokenizer(br.readLine())
        val w = st.nextToken().toInt()
        val p = st.nextToken().toInt()
        if (w != 0) pq.add(Meat(w, p))
    }

    var weight = 0
    var ans = -1
    var prePrice = -1
    var same = 1
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        weight += cur.weight

        if (cur.price == prePrice) same++ else same = 1
        if (weight >= M) {
            ans = cur.price * same
            if (same > 1) {
                while (pq.isNotEmpty()) {
                    val newPrice = pq.poll().price
                    if (newPrice != cur.price) {
                        ans = minOf(newPrice, ans)
                        break
                    }
                }
            }
            break
        }
        prePrice = cur.price
    }

    print(ans)
}

data class Meat(val weight: Int, val price: Int): Comparable<Meat> {
    override fun compareTo(other: Meat): Int {
        if (price == other.price) return other.weight - weight
        return price - other.price
    }
}
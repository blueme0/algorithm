import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    var N = br.readLine().toInt()

    val card = LinkedList<Int>()

    for (i in 1..N) card.offerLast(i)

    while (N > 1) {
        card.pollFirst()
        card.offerLast(card.pollFirst())
        N -= 1
    }

    print(card.poll())
}
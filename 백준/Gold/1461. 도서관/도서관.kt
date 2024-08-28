import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val posBook = PriorityQueue<Int>(reverseOrder())
    val negBook = PriorityQueue<Int>()

    repeat(N) {
        val cur = st.nextToken().toInt()
        if (cur > 0) posBook.add(cur) else negBook.add(cur)
    }

    var steps = 0
    var idx = 0

    if (posBook.isEmpty()) {
        while (negBook.isNotEmpty()) {
            val cur = negBook.poll()
            if (idx % M == 0) {
                steps += if (idx < M) cur * -1 else cur * -2
            }
            idx++
        }
        print(steps)
        return
    }
    if (negBook.isEmpty()) {
        while (posBook.isNotEmpty()) {
            val cur = posBook.poll()
            if (idx % M == 0) {
                steps += if (idx < M) cur else cur * 2
            }
            idx++
        }
        print(steps)
        return
    }

    if (posBook.peek() > negBook.peek() * -1) {
        while (posBook.isNotEmpty()) {
            val cur = posBook.poll()
            if (idx % M == 0) {
                steps += if (idx < M) cur else cur * 2
            }
            idx++
        }

        idx = 0
        while (negBook.isNotEmpty()) {
            val cur = negBook.poll()
            if (idx % M == 0) steps += cur * -2
            idx++
        }
    } else {
        while (negBook.isNotEmpty()) {
            val cur = negBook.poll()
            if (idx % M == 0) {
                steps += if (idx < M) cur * -1 else cur * -2
            }
            idx++
        }

        idx = 0
        while (posBook.isNotEmpty()) {
            val cur = posBook.poll()
            if (idx % M == 0) steps += cur * 2
            idx++
        }
    }

    print(steps)
}
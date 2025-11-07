import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    if (K < 5) {
        print(0)
        return
    }
    if (K == 26) {
        print(N)
        return
    }

    var learned = 0
    for (c in listOf('a', 'n', 't', 'i', 'c')) {
        learned = learned or (1 shl (c - 'a'))
    }

    val words = mutableListOf<Int>()
    repeat(N) {
        st = StringTokenizer(br.readLine())
        words.add(wordToBit(st.nextToken()))
    }

    var answer = 0

    fun dfs(start: Int, cnt: Int, record: Int) {
        if (cnt == K - 5) {
            // 현재 배울 수 있는 수만큼 다 배움!
            var result = 0
            for (word in words) {
                if ((word and record) == word) result++
            }
            answer = maxOf(answer, result)
            return
        }

        for (i in start until 26) {
            val bit = 1 shl i
            if ((record and bit) == 0) {
                dfs(i + 1, cnt + 1, record or bit)
            }
        }
    }

    dfs(0, 0, learned)
    print(answer)
}

fun wordToBit(word: String): Int {
    var bit = 0
    for (ch in word.subSequence(4, word.lastIndex - 3)) {
        bit = bit or (1 shl (ch - 'a'))
    }
    return bit
}

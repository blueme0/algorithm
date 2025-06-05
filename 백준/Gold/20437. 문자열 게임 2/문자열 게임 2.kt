import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(T) {
        val W = br.readLine()
        val K = br.readLine().toInt()
        val game = find(W, K)
        if (game.second == 0) bw.write("-1\n")
        else bw.write("${game.first} ${game.second}\n")
    }
    bw.flush()
    bw.close()
}

fun find(w: String, k: Int): Pair<Int, Int> {
    /**
     * 2개?... 가장 짧은 연속 문자열
     * 문자열 당 cnt
     * 문자열 기록.... LinkedList로 해야 할 듯... HashMap<Int, LinkedList>() 아니면 ?...
     * 만약 이미 K를 만족한다면?... 기록하고 poll() 해주기.... 무조건 K - 1를 유지하도록!
     *
     */
    val map = HashMap<Char, LinkedList<Int>>()
    var shortest = 10000
    var longest = 0

    for (i in w.indices) {
        val ch = w[i]
        if (!map.containsKey(ch)) {
            map[ch] = LinkedList()
        }
        map[ch]?.offer(i)
        if (map[ch]?.size == k) {
            // k개 만족!
            val newLen = i - map[ch]!!.peek() + 1
            if (newLen < shortest) shortest = newLen
            if (newLen > longest) longest = newLen
            map[ch]?.poll()
        }
    }

    return Pair(shortest, longest)
}
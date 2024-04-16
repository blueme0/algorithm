import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var N = 0
var M = 0
var know = ArrayList<Int>()
var party = Array(0) { ArrayList<Int>() }
var people = Array(0) { ArrayList<Int>() }
var visited = booleanArrayOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    party = Array(M + 1) { ArrayList<Int>() }
    people = Array(N + 1) { ArrayList<Int>() }
    visited = BooleanArray(M + 1) { false }

    st = StringTokenizer(br.readLine())
    val know_people = st.nextToken().toInt()
    repeat(know_people) {
        know.add(st.nextToken().toInt())
    }

    for (i in 1..M) {
        st = StringTokenizer(br.readLine())
        val participants = st.nextToken().toInt()
        repeat(participants) {
            val peo_idx = st.nextToken().toInt()
            party[i].add(peo_idx)
            people[peo_idx].add(i)
        }
    }
    bfs()

    print(visited.filter { !it }.size - 1)
}

fun bfs() {
    val queue : Queue<Int> = LinkedList()
    queue.addAll(know)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        for (party_idx in people[cur]) {
            if (visited[party_idx]) continue
            visited[party_idx] = true
            queue.addAll(party[party_idx])
        }
    }
}
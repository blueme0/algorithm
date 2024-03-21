import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var parent = intArrayOf()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    /**
     * 초기 대표 노드는 자기 자신으로 설정
     * 아무 것도 연결된 상태가 아니기 때문
     */
    parent = IntArray(n + 1) { 0 }
    for (i in parent.indices) {
        parent[i] = i
    }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val check = st.nextToken().toInt() == 1
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if (check) {
            val isSame = checkSame(a, b)
            if (isSame) bw.write("YES\n")
            else bw.write("NO\n")
        } else {
            union(a, b)
        }
    }
    bw.flush()
    bw.close()
}

fun union(a: Int, b: Int) {
    val x = find(a)
    val y = find(b)
    /**
     * 대표 노드가 다르면 이를 통일시키기 (연결~)
     */
    if (x != y) parent[y] = x
}

fun find(n: Int): Int {
    /**
     * 대표 노드가 자기 자신일 때까지 들어가기
     */
    if (n == parent[n]) return n
    else {
        parent[n] = find(parent[n])
        return parent[n]
    }
}

fun checkSame(a: Int, b: Int): Boolean {
    /**
     * find 연산을 한 번 해줌으로써
     * union에서 통일한 대표 노드 -> 하위 노드까지 모두 적용 가능
     */
    val x = find(a)
    val y = find(b)
    return x == y
}
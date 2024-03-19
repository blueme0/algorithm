import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    /**
     * 제시된 값 배열에 넣기
     */
    val arr = Array(n) { IntArray(n) { 0 } }
    for (i in 0..< n) {
        st = StringTokenizer(br.readLine())
        for (j in 0..< n) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    /**
     * 합 배열 채우기
     */
    val sumArr = Array(n + 1) { IntArray(n + 1) { 0 } }
    for (i in 1 .. n) {
        for (j in 1 .. n) {
            sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + arr[i - 1][j - 1]
        }
    }

    /**
     * 출력하기
     */
    repeat(m) {
        st = StringTokenizer(br.readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()

        println(sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1])
    }
}
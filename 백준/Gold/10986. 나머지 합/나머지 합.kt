import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())

    val sumArr = LongArray(n + 1) { 0 }
    for (i in 1 .. n) {
        sumArr[i] = sumArr[i - 1] + st.nextToken().toInt()
    }

    val remainderArr = LongArray(m) { 0 }
    var count = 0L
    for (i in 1 .. n) {
        val rem = sumArr[i].rem(m).toInt()
        remainderArr[rem]++
    }
    count += remainderArr[0]

    for (i in 0 ..< m) {
        count += (remainderArr[i] * (remainderArr[i] - 1)) / 2
    }
    print(count)
}
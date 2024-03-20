import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())

    val arr = LongArray(n) { 0L }
    for (i in 0 ..< n) {
        arr[i] = st.nextToken().toLong()
    }
    arr.sort()
    var count = 0

    for (k in 0 ..< n) {
        /**
         * 찾아야 하는 수 k, 시작 포인터 i, 종료 포인터 j
         */
        var i = 0
        var j = n - 1
        val find = arr[k]
        while (i < j) {
            /**
             * i가 j보다 이전에 있을 때까지 계속 탐색 반복
             * 합 == 찾는 수 -> i나 j가 k를 탐색하고 있다면? 다시 찾아야 함 (이동시키기)
             * 합 < 찾는 수 -> i를 다음으로 이동시켜서 더 큰 수를 찾아보기
             * 합 > 찾는 수 -> j를 이전으로 이동시켜서 더 작은 수를 찾아보기
             */
            if (arr[i] + arr[j] == find) {
                if (i != k && j != k) {
                    count++
                    break
                } else if (i == k) {
                    i++
                } else {
                    j--
                }
            }
            else if (arr[i] + arr[j] < find) i++
            else j--
        }
    }
    print(count)
}
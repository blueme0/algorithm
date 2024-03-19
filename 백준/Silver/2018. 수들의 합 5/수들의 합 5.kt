fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var count = 0
    var start_index = 1
    var end_index = 1
    var sum = 1

    /**
     * 1부터 시작!
     * sum < n -> end_index++, sum += end_index
     * sum == n -> count++, end_index++, sum += end_index
     * sum > n -> sum -= start_index, start_index++
     */
    while (start_index <= n) {
        if (sum <= n) {
            if (sum == n) {
                count++
            }
            end_index++
            sum += end_index
        }
        else {
            sum -= start_index
            start_index++
        }
    }
    print(count)
}
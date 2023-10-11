fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()

    /*
    1, 6, 12, 18, 24
    1. 7. 19.
     */

    var now = N - 1
    var cnt = 1
    if (N == 1) print(1)
    else {
        while (true) {
            if (now >= cnt * 6) {
                now -= cnt * 6
                cnt++
            }
            else {
                break
            }
        }
        if (now == 0) println(cnt)
        else println(cnt + 1)
    }

}
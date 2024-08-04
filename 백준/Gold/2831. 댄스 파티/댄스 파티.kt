import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val man = br.readLine().split(" ").map { it.toInt() }.sorted()
    val woman = br.readLine().split(" ").map { it.toInt() }.sorted()

    var manIdx = 0
    var womanIdx = N - 1
    var cnt = 0

    while (manIdx < N && womanIdx >= 0) {
        val cur = man[manIdx] + woman[womanIdx]

        if (cur >= 0) womanIdx--
        else if (cur < -1000) manIdx++
        else {
            womanIdx--
            manIdx++
            cnt++
        }
    }

    print(cnt)
}
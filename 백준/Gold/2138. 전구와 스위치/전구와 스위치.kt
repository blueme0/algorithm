import java.io.BufferedReader
import java.io.InputStreamReader

var N = 0
var goal = BooleanArray(0) { false }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    val zeroOff = br.readLine().map { it == '1' }.toBooleanArray()
    val zeroOn = zeroOff.clone()
    goal = br.readLine().map { it == '1' }.toBooleanArray()

    if (zeroOff.contentEquals(goal)) {
        print(0)
        return
    }

    var ans = reverse(zeroOff, false)
    if (ans != -1) {
        print(ans)
        return
    }

    zeroOn[0] = !zeroOn[0]
    zeroOn[1] = !zeroOn[1]
    ans = reverse(zeroOn, true)
    print(ans)
}

fun reverse(light: BooleanArray, zero: Boolean): Int {
    var cnt = if (zero) 1 else 0
    for (i in 1 until N - 1) {
        if (light[i - 1] != goal[i - 1]) {
            cnt++
            for (j in i - 1 .. i + 1) light[j] = !light[j]
        }
    }
    if (light[N - 1] != goal[N - 1]) {
        cnt++
        light[N - 2] = !light[N - 2]
        light[N - 1] = !light[N - 1]
    }
    return if (light.contentEquals(goal)) cnt else -1
}
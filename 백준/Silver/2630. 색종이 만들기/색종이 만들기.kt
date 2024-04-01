import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var paper = arrayOf(Array<Int>(0) { 0 })
var N = 0

var blue = 0
var white = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    N = st.nextToken().toInt()

    paper = Array (N) { Array (N) { 0 } }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            paper[i][j] = st.nextToken().toInt()
        }
    }

    divide(0, 0, N)

    println(white)
    println(blue)
}

private fun divide(a: Int, b: Int, size: Int) {
    var count = 0
    for (i in a until a + size) {
        for (j in b until b + size) {
            count += paper[i][j]
        }
    }
    if (count == 0) {
        white++
    } else if (count == size * size) {
        blue++
    } else {
        val s = size / 2
        divide(a, b, s)
        divide(a, b + s, s)
        divide(a + s, b, s)
        divide(a + s, b + s, s)
    }
}
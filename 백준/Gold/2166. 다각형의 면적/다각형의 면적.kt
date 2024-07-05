import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.DecimalFormat
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val first = Point(st.nextToken().toLong(), st.nextToken().toLong())
    var cur = first

    var area = 0.0

    repeat(N - 1) {
        st = StringTokenizer(br.readLine())
        val new = Point(st.nextToken().toLong(), st.nextToken().toLong())

        area += cur.x * new.y - cur.y * new.x
        cur = new
    }

    area += cur.x * first.y - cur.y * first.x

    area = Math.abs(area) / 2
    val df = DecimalFormat("#.0")
    df.maximumFractionDigits = 1 // 소수 첫째 자리까지 출력

    val formattedNumber = df.format(Math.round(area * 10) / 10.0)
    print(formattedNumber)
}

data class Point(val x: Long, val y: Long)
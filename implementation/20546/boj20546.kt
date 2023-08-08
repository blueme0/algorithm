fun main() {
    val br = System.`in`.bufferedReader()
    val initialRest = br.readLine().toInt()
    var rest_j = initialRest
    var stock_j = 0
    var rest_s = initialRest
    var stock_s = 0
    var consecutiveIncrease = 0 // 절댓값 3이 기준
    val md = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until 14) {
        if (rest_j >= md[i]) {
            stock_j += rest_j / md[i]
            rest_j %= md[i]
        }
        if (i == 0) continue
        if (md[i] > md[i - 1]) {
            // 가격 상승
            if (consecutiveIncrease < 0) consecutiveIncrease = 0
            consecutiveIncrease++
            if (consecutiveIncrease >= 3) {
                // 3일 연속 전일 대비 상승 -> 전량 매도
                rest_s += stock_s * md[i]
                stock_s = 0
            }
        }
        else if (md[i] < md[i - 1]) {
            // 가격 하락
            if (consecutiveIncrease > 0) consecutiveIncrease = 0
            consecutiveIncrease--
            if (consecutiveIncrease <= -3) {
                // 3일 연속 전일 대비 하락 -> 전량 매수
                if (rest_s < md[i]) continue
                stock_s += rest_s / md[i]
                rest_s %= md[i]
            }
        }
        else {
            // 가격 동일
            consecutiveIncrease = 0
        }
    }
    rest_j += md[13] * stock_j
    rest_s += md[13] * stock_s
    if (rest_j > rest_s) print("BNP")
    else if (rest_j < rest_s) print("TIMING")
    else print("SAMESAME")

}
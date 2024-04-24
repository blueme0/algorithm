import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()
    val map = HashMap<String, Int>()
    map["ISTJ"] = 0
    map["ISTP"] = 0
    map["ISFJ"] = 0
    map["ISFP"] = 0
    map["INTJ"] = 0
    map["INTP"] = 0
    map["INFJ"] = 0
    map["INFP"] = 0
    map["ESTJ"] = 0
    map["ESTP"] = 0
    map["ESFJ"] = 0
    map["ESFP"] = 0
    map["ENTJ"] = 0
    map["ENTP"] = 0
    map["ENFJ"] = 0
    map["ENFP"] = 0

    for (t in 0 until T) {
        val N = br.readLine().toInt()
        val mbti = Array(N) { BooleanArray(4) { false } }
        map.forEach { (t) -> map[t] = 0 }
        val str = br.readLine().split(" ")
        var stop = false
        for (i in 0 until N) {
            if (map[str[i]] == 2) {
                stop = true
                break
            }
            mbti[i][0] = str[i][0] == 'I'
            mbti[i][1] = str[i][1] == 'S'
            mbti[i][2] = str[i][2] == 'T'
            mbti[i][3] = str[i][3] == 'J'
            map[str[i]] = map[str[i]]!! + 1
        }
        if (stop) {
            sb.appendLine(0)
            continue
        }
        var min = Int.MAX_VALUE

        for (i in 0 until N) {
            for (j in i + 1 until N) {
                for (z in j + 1 until N) {
                    var temp_count = 0
                    for (n in 0 until 4) {
                        if (mbti[i][n] != mbti[j][n]) temp_count++
                        if (mbti[i][n] != mbti[z][n]) temp_count++
                        if (mbti[j][n] != mbti[z][n]) temp_count++
                    }
                    min = Math.min(min, temp_count)
                }
            }
        }
        sb.appendLine(min)
    }
    print(sb)
}
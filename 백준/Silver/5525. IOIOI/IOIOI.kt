fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val S = br.readLine()
    var keep = false
    var last = 'S'
    var currentN = 0
    var times = 0

    for (a in S) {
//        println("keep: $keep, last: $last, a: $a, currentN: $currentN, times: $times")
        if (keep) {
            if (last == 'O') {
                if (a == 'I') currentN++
                if (a == 'O') {
                    keep = false
                    currentN = 0
                }
            }
            if (last == 'I') {
                if (a == 'I') currentN = 0
                if (a == 'O') keep = true
            }
        }
        else {
            if (a == 'I') keep = true
        }
        last = a
        if (currentN == N) {
            times++
            currentN--
        }
    }
//    println("keep: $keep, last: $last, currentN: $currentN")
    println(times)
}
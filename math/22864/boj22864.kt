fun main() {
    val br = System.`in`.bufferedReader()
    var fatigue = 0
    var work = 0

    var (A, B, C, M) = br.readLine().split(" ").map { it.toInt() }

    repeat(24) {
        if (fatigue + A > M) {
            fatigue -= C
            if (fatigue < 0) fatigue = 0
        }
        else {
            fatigue += A
            work += B
        }
    }

    println(work)
}
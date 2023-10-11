fun main() {
    val br = System.`in`.bufferedReader()
    while (true) {
        val (A, B, C) = br.readLine().split(" ").map { it.toInt() }
        if (A == 0 && B == 0 && C == 0) break
        if (C > A && C > B) {
            if (A * A + B * B == C * C) println("right")
            else println("wrong")
        }
        else if (B > A && B > C) {
            if (A * A + C * C == B * B) println("right")
            else println("wrong")
        }
        else {
            if (B * B + C * C == A * A) println("right")
            else println("wrong")
        }
    }
}
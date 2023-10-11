fun main() {
    val br = System.`in`.bufferedReader()
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val ml = (1..N).toMutableList()
    val answer = mutableListOf<Int>()

    var point = K - 1
    repeat(N) {
        point %= ml.size
        answer.add(ml[point])
        ml.removeAt(point)
        point += K - 1
    }

    var st = "<"
    st += answer.joinToString(", ")
    st += ">"

    print(st)
}
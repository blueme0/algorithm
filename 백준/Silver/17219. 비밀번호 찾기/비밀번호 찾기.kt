fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val set = HashMap<String, String>()
    repeat(N) {
        val input = br.readLine().split(" ")
        set[input[0]] = input[1]
    }
    repeat(M) {
        println(set[br.readLine()])
    }
}
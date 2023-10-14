fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()

    val arr = Array(15) { Array<Int>(15) { 0 } }
    for (i in 0..14) {
        arr[0][i] = i
        arr[i][1] = 1
    }

    for (i in 1..14) {
        for (j in 2..14) {
            var temp = 0
            for (k in 1..j) {
                temp += arr[i - 1][k]
            }
            arr[i][j] = temp
        }
    }

    repeat(T) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()
        println(arr[k][n])
    }
}
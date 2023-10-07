fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(T) {
        val str = readLine().toCharArray()
        var count = 0
        for (c in str) {
            if (c == '(') count++
            else count--
            if (count < 0) {
                println("NO")
                break
            }
        }
        if (count > 0) println("NO")
        else if (count == 0) println("YES")
    }
}
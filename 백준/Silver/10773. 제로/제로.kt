fun main() {
    val br = System.`in`.bufferedReader()
    val stack: MutableList<Int> = mutableListOf()
    val K = br.readLine().toInt()
    var result = 0
    repeat(K) {
        val num = br.readLine().toInt()
        if (num == 0) {
            result -= stack.removeLast()
        }
        else {
            result += num
            stack.add(num)
        }
    }
    print(result)
}
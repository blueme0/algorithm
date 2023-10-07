fun main() {
    val br = System.`in`.bufferedReader()
    while (true) {
        val num = br.readLine().toCharArray()
        if (num[0] == '0') break
        val stack: MutableList<Char> = mutableListOf()
        for (i in 0 until num.size / 2) {
            stack.add(num[i])
        }
        val left = num.size / 2 + num.size % 2

        var isTrue = true
        for (i in left until num.size) {
            if (stack.removeLast() != num[i]) {
                isTrue = false
                break
            }
        }
        if (isTrue) println("yes")
        else println("no")
    }
}
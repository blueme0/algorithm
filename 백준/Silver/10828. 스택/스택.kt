fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(N) {
        val str = br.readLine().split(" ")
        when (str[0]) {
            "push" -> numbers.add(str[1].toInt())
            "pop" -> {
                if (numbers.isEmpty()) println(-1)
                else println(numbers.removeLast())
            }
            "size" -> println(numbers.size)
            "empty" -> {
                if (numbers.isEmpty()) println(1)
                else println(0)
            }
            "top" -> {
                if (numbers.isEmpty()) println(-1)
                else println(numbers.last())
            }
        }
    }
}

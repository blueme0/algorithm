fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val list = mutableSetOf<Int>()

    for (i in 1..nums[0]) {
        if (nums[0] % i == 0) list.add(i)
    }

    for (i in 1 until N) {
        val temp = mutableSetOf<Int>()
        temp.addAll(list)
        for (div in temp) {
            if (nums[i] % div != 0) list.remove(div)
        }
    }

    for (div in list) {
        println(div)
    }
}
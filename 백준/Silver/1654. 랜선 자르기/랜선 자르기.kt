fun main() {
    val br = System.`in`.bufferedReader()
    val (K, N) = br.readLine().split(" ").map { it.toInt() }
    val arr = mutableListOf<Int>()
    var end: Long = 0
    repeat(K) {
        val num = br.readLine().toInt()
        arr.add(num)
        if (end < num) end = num.toLong()
    }

    var start: Long = 1
    var mid: Long = (start + end) / 2
    var length: Long = 0

    while (start <= end) {
        var count: Long = 0
        for (i in arr) {
            count += i / mid
        }

        if (count >= N) {
            if (length < mid) length = mid
            start = mid + 1
        }
        else {
            end = mid - 1
        }
        mid = (start + end) / 2
    }

    print(length)
}
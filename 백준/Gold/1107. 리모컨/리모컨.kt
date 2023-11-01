fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val rc = Array(10) { false }
    if (m != 0) {
        val broken = br.readLine().split(" ").map { it.toInt() }
        for (i in 0 until m) {
            rc[broken[i]] = true
        }
    }
    var bigger = 0
    for (i in n .. 1000000) {
        var passed = true
        for (k in i.toString()) {
            if (rc[k.digitToInt()]) {
                passed = false
                break
            }
        }
        if (passed) {
            bigger = i
            break
        }
    }

    var smaller = 500000
    for (i in n downTo 0) {
        var passed = true
        for (k in i.toString()) {
            if (rc[k.digitToInt()]) {
                passed = false
                break
            }
        }
        if (passed) {
            smaller = i
            break
        }
    }

    val biggerLen = bigger.toString().length
    val smallerLen = smaller.toString().length
    val withhundred: Int = if (n > 100) n - 100 else 100 - n

    if (bigger != 0) {
        bigger = bigger - n + biggerLen
        var nsmaller: Int = 1000000
        if (smaller != 500000) nsmaller = n - smaller + smallerLen
//        println("1 - bigger: $bigger, smaller: $nsmaller, 100: $withhundred")
        if (bigger < nsmaller && bigger < withhundred) {
            print(bigger)
            return
        }
    }
    if (smaller != 500000) {
        smaller = n - smaller + smallerLen
//        println("2 - bigger: $bigger, smaller: $smaller, 100: $withhundred")
        if (smaller < withhundred) {
            print(smaller)
            return
        }
    }
//    println("3 - bigger: $bigger, smaller: $smaller, 100: $withhundred")
    print(withhundred)
}
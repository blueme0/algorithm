fun main() {
    val br = System.`in`.bufferedReader()
    val (A, B, V) = br.readLine().split(" ").map { it.toInt() }

//    var height = 0
//    var date = 1
//    while (true) {
//        height += A
//        if (height >= V) {
//            break
//        }
//        height -= B
//        date++
//    }
//    println(date)

    var oneday = A - B
    var date = (V - A) / oneday + 1
    if ((V - A) % oneday != 0) date++
    println(date)

}
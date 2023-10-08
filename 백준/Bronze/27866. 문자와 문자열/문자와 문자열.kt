fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    println(str.toCharArray()[br.readLine().toInt() - 1])
}
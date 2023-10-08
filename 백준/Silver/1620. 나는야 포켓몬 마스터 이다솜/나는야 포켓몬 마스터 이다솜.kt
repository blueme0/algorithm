import java.io.BufferedWriter
import java.io.OutputStream
import java.io.OutputStreamWriter

fun main() {
    val br = System.`in`.bufferedReader()
    val cmd = br.readLine().split(" ")
    val N = cmd[0].toInt()
    val M = cmd[1].toInt()

    val keyToPocketmon = mutableMapOf<Int, String>()
    val pocketmonToKey = mutableMapOf<String, Int>()

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 1..N) {
        val name = br.readLine()
        keyToPocketmon[i] = name
        pocketmonToKey[name] = i
    }

    repeat(M) {
        val str = br.readLine()
        if (str[0].isDigit()) {
            bw.write("${keyToPocketmon[str.toInt()]}\n")
        }
        else {
            bw.write("${pocketmonToKey[str]}\n")
        }
    }

    bw.flush()
    bw.close()
}
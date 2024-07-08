import java.io.BufferedReader
import java.io.InputStreamReader

val existInX = Array(9) { Array<Boolean>(10) { false } }
val existInY = Array(9) { Array<Boolean>(10) { false } }
val existInSquare = Array(9) { Array<Boolean>(10) { false } }
val sudoku = Array(9) { Array<Int>(9) { 0 } }
var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 0 until 9) {
        val line = br.readLine()
        for (j in 0 until 9) {
            sudoku[i][j] = line[j].digitToInt()
            if (sudoku[i][j] != 0) {
                existInX[i][sudoku[i][j]] = true
                existInY[j][sudoku[i][j]] = true
                existInSquare[square(i, j)][sudoku[i][j]] = true
            }
        }
    }
    go(0)
}

fun square(x: Int, y: Int): Int {
    return (x / 3) * 3 + (y / 3)
}

fun go(z: Int): Boolean {
    cnt++
    if (cnt >= 10000000) return true
    if (z == 81) {
        printSudoku()
        return true
    }
    val x = z / 9
    val y = z % 9
    if (sudoku[x][y] != 0) return go(z + 1)
    for (i in 1..9) {
        val inSquare = square(x, y)
        if (!existInX[x][i] && !existInY[y][i] && !existInSquare[inSquare][i]) {
            sudoku[x][y] = i
            existInX[x][i] = true
            existInY[y][i] = true
            existInSquare[inSquare][i] = true
            if (go(z + 1)) return true
            sudoku[x][y] = 0
            existInX[x][i] = false
            existInY[y][i] = false
            existInSquare[inSquare][i] = false
        }
    }
    return false
}

fun printSudoku() {
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            print(sudoku[i][j])
        }
        println()
    }
}
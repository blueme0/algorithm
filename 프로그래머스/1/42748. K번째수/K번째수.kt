import java.util.*

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        for (cmd in commands) {
            val (i, j, k) = cmd.map { it.toInt() - 1 }
            val sliced = array.sliceArray(i..j)
            sliced.sorted()[k].let { answer.add(it) }
        }
        return answer.toIntArray()
    }
}

/**
    i ~ j 숫자 자르고 정렬. k번째에 있는 수?..
    (i - 1) ~ (j - 1) 수
    -> sort
    
*/
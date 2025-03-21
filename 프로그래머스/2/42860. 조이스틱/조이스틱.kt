class Solution {
    fun solution(name: String): Int {
        val alpha = IntArray(name.length) { 0 }
        val size = alpha.size
        for (i in 0 until name.length) {
            val ch = name[i]
            if (ch > 'N') alpha[i] = ('Z' + 1 - ch).toInt()
            else alpha[i] = (ch - 'A').toInt()
        }
        
        var answer = alpha.sum() + size - 1
        val sum = alpha.sum()
        var aCnt = 0
        var aStart = 0
        for (i in 1 until size) {
            if (alpha[i] == 0) {
                if (aCnt == 0) aStart = i
                aCnt++
            } else if (aCnt != 0) {
                // 계산하기
                var result = sum
                result += aStart - 1
                result += size - (aStart + aCnt)
                result += Math.min(aStart - 1, size - (aStart + aCnt))
                answer = Math.min(answer, result)
                aCnt = 0
            }
        }
        if (aCnt > 0) {
            var result = sum
            result += aStart - 1
            answer = Math.min(answer, result)
        }
        
        return answer
    }
    
}

// 12, 15, 19, 21
class Solution {
    fun solution(numbers: IntArray): String {
        val testZero = numbers.toMutableSet().apply {
            remove(0)
        }
        if (testZero.isEmpty()) return "0"
        var answer = numbers.sortedWith(kotlin.Comparator { o1, o2 -> 
            return@Comparator "$o2$o1".compareTo("$o1$o2")
        }).joinToString("")
        return answer
    }
}

/**
    3330333
    3340
    3344
    
    334
*/
class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val rest: BooleanArray = BooleanArray(n + 2) { false }
        for (who in reserve) rest[who] = true
        val need = mutableListOf<Int>()
        for (who in lost) {
            if (rest[who]) rest[who] = false
            else need.add(who)
        }
        need.sort()
        var answer = n
        for (who in need) {
            /**
                2.
                1이나 3이 있으면 가져오기
                (1)이 먼저~
            */
            if (rest[who - 1]) rest[who - 1] = false
            else if (rest[who + 1]) rest[who + 1] = false
            else answer--
        }
        return answer
    }
}

/**

    바로 앞 / 뒤 학생에게만 대여 가능
    최대한 많은 학생이 체육 수업
    전체

*/

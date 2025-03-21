import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        // Pair(idx, num)
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        var rest = k
        
        pq.add(Pair(0, number[0].digitToInt()))
        var lastIdx = -1
        for (i in 1 until number.length) {
            while (pq.isNotEmpty() && rest > 0 && pq.peek().second < number[i].digitToInt()) {
                pq.poll()
                rest--
            }
            if (rest == 0) {
                lastIdx = i
                break
            }
            pq.add(Pair(i, number[i].digitToInt()))
        }
        while (pq.isNotEmpty() && rest > 0) {
            pq.poll()
            rest--
        }
        
        var answer = ""
        val newPq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        newPq.addAll(pq)
        while (newPq.isNotEmpty()) answer += newPq.poll().second.toString()
        if (lastIdx != -1) answer += number.substring(lastIdx until number.length)
        
        return answer
    }
}

/**

42177252841
(1) < (2)면 (1)을 바로 없애기
-> 앞에 있는 것 중에 가장 작은 것을 없애기
앞에 있는 것중에 가장 작은 것이 (2)보다 작다면 없애는거야

(1) == (2)면 다음 단계
(1) > (2)여도 다음 단계

4277252841

477252841

77252841

7752841

775841

끝까지 작아질 때까지 (i - 1 < i)일 때까지 계속 ㄱㄱ하다가
작아지면? i - 1를 빼


*/
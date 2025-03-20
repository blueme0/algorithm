import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        val minPq = PriorityQueue<Int>()
        val maxPq = PriorityQueue<Int>(reverseOrder())
        var size = 0
        val cntMap: HashMap<Int, Int> = hashMapOf()
        
        for (op in operations) {
            val (cmd, num) = op.split(" ")
            if (cmd == "I") {
                val cur = num.toInt()
                minPq.offer(cur)
                maxPq.offer(cur)
                cntMap[cur] = (cntMap[cur]?:0) + 1
                size++
            } else if (num == "1" && size > 0) {
                var cur = maxPq.poll()
                while (cntMap[cur]?:0 == 0) cur = maxPq.poll()
                cntMap[cur] = (cntMap[cur]?:1) - 1
                size--
            } else if (size > 0) {
                var cur = minPq.poll()
                while (cntMap[cur]?:0 == 0) cur = minPq.poll()
                cntMap[cur] = (cntMap[cur]?:1) - 1
                size--
            }
            
        }
        
        if (size == 0) answer = intArrayOf(0, 0)
        else {
            var max = maxPq.poll()
            while (cntMap[max]?:0 == 0) max = maxPq.poll()
            var min = minPq.poll()
            while (cntMap[min]?:0 == 0) min = minPq.poll()
            answer = intArrayOf(max, min)
        }
        
        return answer
    }
}

/**
    이중 우선순위 큐
    명령어
    I {숫자}: 숫자 Insert
    D 1: 큐에서 최댓값 삭제
    D -1: 큐에서 최솟값 삭제
    
    pq 2개
    
    10, 20
    - max[10, 20], min[10, 20]
    10
    - max[10], min[10, 20]
    10, 30
    - max[10, 30], min[10, 20, 30]
    10, 30, 40
    - max[10, 30, 40], min[10, 20, 30, 40]
    30, 40
    - max[10, 30, 40], min[20, 30, 40]
    40
    - max[10, 30, 40], min[30, 40]
*/
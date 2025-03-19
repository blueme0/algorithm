import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val arr = Array(101) { ArrayList<Int>() }

        var lastIdx = -1
        val pq: PriorityQueue<Int> = PriorityQueue(kotlin.Comparator { o1, o2 ->
            return@Comparator if (priorities[o1] != priorities[o2]) priorities[o2] - priorities[o1]
            else if (lastIdx < o1 && lastIdx < o2 || lastIdx > o1 && lastIdx > o2) o1 - o2
            else if (lastIdx < o1) -1
            else 1
        })

        for (i in priorities.indices) arr[priorities[i]].add(i)
        var cnt = 0
        for (i in 100 downTo 1) {
            pq.addAll(arr[i])
            while (pq.isNotEmpty()) {
                val cur = pq.poll()
                cnt++
                lastIdx = cur
                if (lastIdx == location) break
            }
            if (lastIdx == location) break
        }
        return cnt
    }
}
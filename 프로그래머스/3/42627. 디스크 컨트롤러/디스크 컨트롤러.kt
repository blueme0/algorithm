import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        data class Job(
            val number: Int,
            val request: Int,
            val time: Int
        ): Comparable<Job> {
            override fun compareTo(other: Job): Int {
                return if (time != other.time) time - other.time
                else if (request != other.request) request - other.request
                else number - other.number
            }
        }
        
        var cnt = jobs.size
        
        var time = 0
        var answer = 0
        val queue = PriorityQueue<Job>()
        val waitQueue = PriorityQueue<Job>(compareBy { it.request })
        
        for (i in jobs.indices) {
            waitQueue.offer(Job(i, jobs[i][0], jobs[i][1]))
        }
        
        while (waitQueue.isNotEmpty()) {
            // waitQueue에 있는 것 중에 queue 요청 시각이 되었으면!!
            while (waitQueue.isNotEmpty() && waitQueue.peek().request <= time) queue.offer(waitQueue.poll())
            
            if (queue.isEmpty()) time++
            else {
                val cur = queue.poll()
                time += cur.time
                answer += (time - cur.request)
            }
        }
        
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
                time += cur.time
                answer += (time - cur.request)
        }
        
        println("time: $time, cnt: $cnt, answer: $answer")
        return (answer / cnt)
    }
}

/**
    HDD는 한 번에 하나의 작업만 수행, 작업 마칠 때까지 그 작업만 수행
    우선순위 디스크 컨트롤러
    대기 큐에 (작업의 번호, 요청 시각, 소요 시간) 저장, 처음에는 empty
    if (!HDD.isWorking() && !queue.isEmpty()) {
        val cur = queue.poll()
        HDD야 너 일 해
        (우선순위 높은 것: 1. 소요 시간 짧은 것, 2. 요청 시각 빠른 것, 3. 작업 번호 작은 것)
    }
*/
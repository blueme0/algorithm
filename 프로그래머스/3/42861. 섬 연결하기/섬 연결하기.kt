import java.util.*

class Solution {
    var map: Array<Array<Int>> = arrayOf()
    var N = 0
    var visited = booleanArrayOf()

    fun solution(n: Int, costs: Array<IntArray>): Int {
        data class Route(
            val a: Int,
            val b: Int,
            val cost: Int
        )
        N = n
        map = Array(n) { Array(n) { 0 } } 
        val routePq = PriorityQueue<Route>(compareByDescending { it.cost })
        for (arr in costs) {
            routePq.add(Route(arr[0], arr[1], arr[2]))
            map[arr[0]][arr[1]] = arr[2]
            map[arr[1]][arr[0]] = arr[2]
        }
        var answer = 0

        while (routePq.isNotEmpty()) {
            val cur = routePq.poll()
            map[cur.a][cur.b] = 0
            map[cur.b][cur.a] = 0
            visited = BooleanArray(N) { false }
            val result = check(cur.a, cur.b)
            if (!result) {
                answer += cur.cost
                map[cur.a][cur.b] = cur.cost
                map[cur.b][cur.a] = cur.cost
            }
        }
        return answer
    }
    
    fun check(start: Int, end: Int): Boolean {
        if (start == end) return true
        if (visited[start]) return false
        
        visited[start] = true
        var result = false
        for (p in 0 until N) {
            // println("start: $start, p: $p")
            if (map[start][p] > 0) result = result || check(p, end)
            if (result) return true
        }
        return result
    }
    
    
}

/**
    섬 개수 1 <= n <= 100
    
    costs[i]: { p1, p2, cost }
    모두 이어져있음
    
*/
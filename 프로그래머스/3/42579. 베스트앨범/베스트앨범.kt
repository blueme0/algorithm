import java.util.*

class Solution {
     fun solution(genres: Array<String>, plays: IntArray): IntArray {

        val cnt = genres.size
        var answer = intArrayOf()

        class Genre {
            var total: Int = 0
            private var first: Int = -1
            private var second: Int = -1
            fun checkNew(idx: Int) {
                if (first == -1) {
                    first = idx
                } else if (plays[first] < plays[idx]) {
                    second = first
                    first = idx
                } else if (second == -1) {
                    second = idx
                } else if (plays[second] < plays[idx]) {
                    second = idx
                }
            }
            fun getFirst(): Int? = if (first == -1) null else first
            fun getSecond(): Int? = if (second == -1) null else second
        }

        val genreHashMap: HashMap<String, Genre> = hashMapOf()
        val pq: PriorityQueue<String> = PriorityQueue(compareByDescending { genreHashMap[it]?.total ?: 0})

        for (i in 0 until cnt) {
            if (genreHashMap.containsKey(genres[i])) {
                genreHashMap[genres[i]]?.apply {
                    this.total += plays[i]
                    this.checkNew(i)
                }
            } else {
                genreHashMap[genres[i]] = Genre().apply {
                    this.total = plays[i]
                    this.checkNew(i)
                }
            }
        }

        pq.addAll(genreHashMap.keys)
        
        val list = mutableListOf<Int>()
        while (pq.isNotEmpty()) {
            val cur = genreHashMap[pq.poll()] ?: continue
            cur.getFirst()?.let { list.add(it) }
            cur.getSecond()?.let { list.add(it) }
        }
        answer = list.toIntArray()
        return answer
    }
}
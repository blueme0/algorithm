class Solution {
    fun solution(citations: IntArray): Int {
        val sorted = citations.sortedDescending()
        val idx = sorted.size
        for (i in 1..idx) {
            if (i == sorted[i - 1]) return i
            else if (i > sorted[i - 1]) return i - 1
        }
        return idx
    }
}

/**
    n편 중, h번 이상 인용된 논문이 h편 이상?....... 나머지 논문이 h번 이하?...... -. h의 최댓값
    
    [3, 0, 6, 1, 5]
    [6, 5, 3, 1, 0]
    
    1, 2, 3, 4, 5편이라고 하자.
    위에서부터 돌아.
    6번 이상 인용된 논문 1개
    5번 이상 인용된 논문 2개
    
    [7, 6, 5, 5, 5, 4, 3, 3, 2, 1, 1, 0]
    7번 이상 1개
    6번 이상 2개
    5번 이상 3, 4, 5개
    4번 이상 6개
    3번 이상 7, 8개
    2번 이상 9개
    1번 이상 10, 11개
    0번 이상 12개
*/
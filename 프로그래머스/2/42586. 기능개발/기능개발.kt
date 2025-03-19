class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var max = -1
        var cnt = 0
        
        val list = mutableListOf<Int>()
        val size = progresses.size
        var day = 0
        for (i in 0 until size) {
            val remain = 100 - progresses[i]
            day = remain / speeds[i]
            if (remain % speeds[i] != 0) day++
            
            if (max == -1){
                max = day
            }
            else if (day > max) {
                max = day
                list.add(cnt)
                cnt = 0
            }
            cnt++
        }
        list.add(cnt)
        
        return list.toIntArray()
    }
}
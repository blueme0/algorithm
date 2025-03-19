import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        data class Truck(
            val start: Int,
            val weight: Int
        )
        var time = 0
        var total_weight = 0
        val bridge_queue = LinkedList<Truck>()
        
        for (truck in truck_weights) {
            time++

            while (total_weight + truck > weight || bridge_queue.size >= bridge_length) {
                // println("over..: ($total_weight + $truck) > $weight || ${bridge_queue.size} >= $bridge_length")
                val last_truck = bridge_queue.poll()
                time = last_truck.start + bridge_length
                total_weight -= last_truck.weight
            }
            
            val peek_truck = bridge_queue.peek()
            if (peek_truck != null && peek_truck.start + bridge_length <= time) {
                bridge_queue.poll()
                total_weight -= peek_truck.weight
            }
            
            bridge_queue.offer(Truck(time, truck))
            total_weight += truck
            // println("time: $time, trucks: ${bridge_queue}")
        }
        
        if (bridge_queue.isEmpty()) return time
        while (bridge_queue.size > 1) bridge_queue.poll()
        time = bridge_queue.poll().start + bridge_length
        return time
    }
}
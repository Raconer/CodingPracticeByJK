import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
          val minQ = PriorityQueue<Int>()                            // 오름차순 (최솟값)
    val maxQ = PriorityQueue<Int>(compareByDescending { it })   // 내림차순 (최댓값)

    operations.forEach { op ->
        when {
            op.startsWith("I ") -> {
                val num = op.substring(2).toInt()
                minQ.add(num)
                maxQ.add(num)
            }
            op == "D 1" -> {
                if (maxQ.isNotEmpty()) {
                    val max = maxQ.poll()
                    minQ.remove(max)
                }
            }
            op == "D -1" -> {
                if (minQ.isNotEmpty()) {
                    val min = minQ.poll()
                    maxQ.remove(min)
                }
            }
        }
    }

    return if (minQ.isEmpty()) intArrayOf(0, 0)
    else intArrayOf(maxQ.peek(), minQ.peek())
    }
}
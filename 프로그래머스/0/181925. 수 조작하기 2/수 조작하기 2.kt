class Solution {
    fun solution(numLog: IntArray): String {
        val size = numLog.size - 1
    val sb = StringBuilder()
    (0 until size).forEachIndexed{ i, value ->
        when(numLog[i+1] - numLog[i]){
            1 -> sb.append("w")
            -1 -> sb.append("s")
            10 -> sb.append("d")
            -10 -> sb.append("a")
        }
    }
        return sb.toString()
    }
}
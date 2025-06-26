class Solution {
    fun solution(num_list: IntArray): IntArray {
        val numList = num_list.toMutableList()
        val (a, b) = numList.takeLast(2)
        numList += if (a < b) b - a else b * 2
        return numList.toIntArray()
    }
}
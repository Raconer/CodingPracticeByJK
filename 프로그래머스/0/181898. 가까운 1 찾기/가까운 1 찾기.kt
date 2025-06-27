class Solution {
    fun solution(arr: IntArray, idx: Int): Int {
        val value = arr.copyOfRange(idx, arr.size).indexOfFirst { it == 1 }
        return if(value == -1) value else value  + idx
    }
}
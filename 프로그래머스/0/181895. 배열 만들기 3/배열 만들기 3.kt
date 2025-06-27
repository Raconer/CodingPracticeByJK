class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
          return  intervals.flatMap {
             arr.copyOfRange(it[0], it[1]+1).toList()
         }.toIntArray()
    }
}
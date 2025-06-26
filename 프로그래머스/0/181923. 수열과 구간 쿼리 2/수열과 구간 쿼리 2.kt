class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        return  queries.map {
           val temp = arr.copyOfRange(it[0], it[1] + 1)
           temp.sort()
           temp.firstOrNull { value -> it[2] < value } ?:-1
        }.toIntArray()
    }
}
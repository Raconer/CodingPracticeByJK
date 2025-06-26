class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        return queries.map {
            arr.copyOfRange(it[0], it[1] + 1).filter {  value -> it[2] < value }.minOrNull()?:-1
        }.toIntArray()
    }
}
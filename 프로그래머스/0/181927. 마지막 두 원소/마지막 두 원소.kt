class Solution {
    fun solution(num_list: IntArray): IntArray {
        val numList = num_list.mapTo(arrayListOf()) { it }
        numList.takeLast(2).let {
            val last = it[1]
            val secondLast = it[0]
            val value = if(secondLast < last) {
                last - secondLast
            } else {
                last * 2
            }
            numList.add(value)
        }
        return numList.toIntArray()
    }
}
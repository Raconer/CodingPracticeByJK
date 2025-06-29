class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
           var answer = arrayListOf<Int>()
        val photoMap = name.withIndex().associate { (i, value) -> value to yearning[i] }.toMutableMap()

        photo.forEach {
            val sum = photoMap.filter { map -> it.contains(map.key) }.values.sum()
            answer.add(sum)
        }

        return answer.toIntArray()
    }
}
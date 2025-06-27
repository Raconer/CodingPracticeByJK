class Solution {
    fun solution(my_string: String): Array<String> {
           var answer = mutableListOf<String>()
        val size = my_string.length
        my_string.forEachIndexed { index , value ->
            answer.add(my_string.substring(index, size))
        }

        answer.sort()
        return answer.toTypedArray()
    }
}
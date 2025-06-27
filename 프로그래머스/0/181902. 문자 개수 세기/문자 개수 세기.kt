class Solution {
    fun solution(my_string: String): IntArray {
        var answer: IntArray = IntArray(52)

        my_string.forEach {
            val index = it.code - if(it.code >= 97) 71 else 65
            answer[index] = answer[index] + 1
        }

        return answer
    }
}
class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        val stringList = my_string.toList()
        val sb = StringBuilder()
        index_list.forEach {
            sb.append(stringList[it])
        }

        return sb.toString()
    }
}
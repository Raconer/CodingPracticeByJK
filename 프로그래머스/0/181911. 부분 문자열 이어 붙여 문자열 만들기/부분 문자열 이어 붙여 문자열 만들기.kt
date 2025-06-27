class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
         return my_strings.withIndex().map { (index, value) ->
            val part = parts[index]
            val data = value.substring(part[0] .. part[1])
            data
        }.joinToString("")
    }
}
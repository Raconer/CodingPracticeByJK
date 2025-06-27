class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        return my_strings.withIndex().map { (index, value) ->
            value.substring(parts[index][0] .. parts[index][1])
        }.joinToString("")
    }
}
class Solution {
    fun solution(my_string: String, indices: IntArray): String {
     return my_string.filterIndexed{ idx, value ->
            !indices.contains(idx)
        }
    }
}
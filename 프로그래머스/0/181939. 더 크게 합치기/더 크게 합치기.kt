class Solution {
    fun solution(a: Int, b: Int): Int {
        return maxOf("$a$b".toInt(), "$b$a".toInt())
    }
}
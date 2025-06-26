class Solution {
    fun solution(a: Int, b: Int): Int {
        return maxOf("$a$b".toInt(), (2*a*b))
    }
}
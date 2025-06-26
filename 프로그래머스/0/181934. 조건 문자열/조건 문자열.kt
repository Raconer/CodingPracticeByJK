class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        val isResult = when("$ineq$eq"){
            ">!" -> n > m
            ">=" -> n >= m
            "<!" -> n < m
            "<=" -> n <= m
            else -> false
        }
        return if(isResult) 1 else 0
    }
}
class Solution {
    fun solution(n: Int): Int {
        val isEven = n % 2 == 0
        return (n downTo 1 step 2).sumOf{
            if(isEven) it *it
            else it
        }
    }
}
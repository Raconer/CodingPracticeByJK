class Solution {
    fun solution(n: Int, k: Int): IntArray {
             return (1..n/k).map{
            it * k
        }.toIntArray()
    }
}
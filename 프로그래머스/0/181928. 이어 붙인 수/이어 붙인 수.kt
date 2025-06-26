class Solution {
    fun solution(num_list: IntArray): Int {
        val v1 = StringBuilder()
        val v2 = StringBuilder()
        
        num_list.forEach{
            if(it % 2 == 0) v2.append(it)
            else v1.append(it)
        }   
        
        return v1.toString().toInt() + v2.toString().toInt()
    }
}
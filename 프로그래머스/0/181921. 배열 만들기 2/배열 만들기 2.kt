class Solution {
    fun solution(l: Int, r: Int): IntArray {
        val answer = mutableListOf<Int>()

        for (i in l..r) {
           if(i.toString().all { it == '5' || it == '0' }) answer.add(i)
        }

        if(answer.isEmpty()) answer.add(-1)
        return answer.toIntArray()
    }
}
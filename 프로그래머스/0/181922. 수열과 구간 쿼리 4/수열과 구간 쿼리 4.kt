class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
         queries.forEach {
       for(i in it[0] .. it[1]){
           if(i%it[2] == 0) arr[i] += 1
       }
    }

        return arr
    }
}
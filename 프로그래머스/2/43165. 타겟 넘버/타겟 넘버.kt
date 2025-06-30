class Solution {
     var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
         answer = 0

        this.dfs(numbers, target, 0, 0)
        return answer
    }
    
     private fun dfs(numbers: IntArray, target: Int, i:Int, sum:Int){
        if(i == numbers.size ){
            if (sum  == target){
                answer++
            }
            return
        }

        dfs(numbers, target, i + 1, sum + numbers[i])
        dfs(numbers, target, i + 1, sum - numbers[i])
    }
}
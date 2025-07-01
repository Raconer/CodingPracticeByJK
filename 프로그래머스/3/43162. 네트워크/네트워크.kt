class Solution {
    lateinit var network : Array<IntArray>
    var size = 0
    var answer = 0
    
    
    fun solution(n: Int, computers: Array<IntArray>): Int {
        network = computers
        size = n

        for (i in 0 until size) {
            if(network[i][i] == 1) {
                this.dfs(i, 0)
                answer += 1
    
            }
        }
        return answer
    }
    
      private fun dfs(y:Int, x:Int){

        if(y < size && x < size ){
            if(network[y][x] == 1){
                network[y][x] = 0
                for(i in 0 until size){
                    this.dfs(x, i)
                }
            } else {
                this.dfs(y, x + 1)
            }
        }
    }

}
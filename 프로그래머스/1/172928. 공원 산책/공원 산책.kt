class Solution {
      var maxX = 0
    var maxY = 0
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val parkArray = park.map { it.map { it } }
        maxX = routes[0].length - 1
        maxY = routes.size - 1

        var (startY, startX) = this.findStartPoint(park)
        routes.forEach {
            val route = it.split(" ")

            val (tempX, tempY) = this.moveStep(parkArray, startX, startY, route[0], route[1].toInt())

            startX = tempX
            startY = tempY

        }
        return intArrayOf(startY, startX)
    }
    
    private fun moveStep(park:List<List<Char>>, startX:Int, startY:Int, direction: String, steps: Int) : Pair<Int,Int> {
        var targetX:Int? = null
        var targetY:Int? = null


        when(direction){
            "S" -> {targetY = startY + steps }
            "N" -> {targetY = startY - steps }
            "E" -> {targetX = startX + steps }
            "W" -> {targetX = startX - steps }
        }
      
        targetX?.let {
            if(0 <= it && it < park[0].size ){
                for(x in if(startX < it ) startX..it else startX downTo it){

                    if(park[startY][x] == 'X'){
                        targetX = null
                        break
                    }
                }
            } else targetX = null

        }
        targetY?.let {
            if(0 <= it &&  it < park.size ){
                for(y in if(startY < it ) startY..it else startY downTo it){
                    if(park[y][startX] == 'X'){
                        targetY = null
                        break
                    }
                }
            } else targetY = null
        }
        return Pair(targetX?:startX, targetY?:startY)
    }

    private fun findStartPoint(park: Array<String>): Pair<Int, Int> {
        park.forEachIndexed { xIndex, valStr ->
            valStr.forEachIndexed { yIndex, valChar ->
                if(valChar == 'S') {
                    return Pair(xIndex, yIndex)
                }
            }
        }

        return Pair(-1, -1)
    }
}
class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
         val playersList = players
        val playersMap=  players.withIndex().associate { (index, value) -> value to index }.toMutableMap()

        callings.forEach { playerName ->
            val index = playersMap[playerName]!!
            if(0 < index ){
                val temp = playersList[index]
                val temp2 =  playersList[index -1]

                playersList[index] = playersList[index -1]
                playersList[index - 1] = temp

                playersMap[playerName] = index -1
                playersMap[temp2] = index
            }
        }

        return playersList
    }
}
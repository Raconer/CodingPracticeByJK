import java.util.stream.IntStream

class Solution {
  fun sortPlaysByGenres(genresPlayRankMap: HashMap<String, MutableMap<Int, MutableList<Int>>>): IntArray {
        val result = ArrayList<Int>()
        genresPlayRankMap.entries.sortedByDescending {
           it.value.keys.sum()
        }.forEach {

            println(it.key +" - "+ it.value.keys.sum())
            it.value.entries.sortedByDescending { it.key }.flatMap {
                it.value
            }.let {
                val size = it.size
                if(size > 1){
                    result.add(it[0])
                    result.add(it[1])
                } else if(size > 0){
                    result.add(it[0])
                }
            }
        }

       return result.toIntArray()
    }

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val genresPlayRankMap = HashMap<String, MutableMap<Int, MutableList<Int>>>()
        val size = genres.size

        IntStream.range(0, size).forEach{i ->
            // 장르 이름
            val name = genres[i]
            // 장르의 플레이 횟수
            val playCnt = plays[i]
            genresPlayRankMap.getOrPut(name) {
                mutableMapOf()
            }.getOrPut(playCnt){ mutableListOf()}.add(i)
        }

        return this.sortPlaysByGenres(genresPlayRankMap)
    }
}
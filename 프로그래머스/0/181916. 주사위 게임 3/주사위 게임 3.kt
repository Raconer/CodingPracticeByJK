class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
       val hashMap = HashMap<Int, Int>()
        hashMap[a] = hashMap.getOrDefault(a, 0) + 1
        hashMap[b] = hashMap.getOrDefault(b, 0) + 1
        hashMap[c] = hashMap.getOrDefault(c, 0) + 1
        hashMap[d] = hashMap.getOrDefault(d, 0) + 1

        val size = hashMap.size
        return if(size == 4) hashMap.minOf { it.key }
               else if(size == 3) hashMap.filter { it.value == 1 }.toList().fold(1){acc, (key, value) -> acc * key}
               else if(size == 2){
                   if(hashMap[a] == 2){
                       val temp = hashMap.map { it.key }.toList()
                       (temp[0] + temp[1]) * Math.abs(temp[0] - temp[1])
                   } else {
                      val temp = 10 * hashMap.maxByOrNull { it.value }!!.key + hashMap.minByOrNull { it.value }!!.key
                      
                       temp * temp
                   }
               }
                else a * 1111
    }
}
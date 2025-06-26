class Solution {
    fun solution(str1: String, str2: String): String {
        val sb = StringBuilder()
        val length = str1.length -1
        for(i in 0 .. length){
            sb.append(str1[i])
            sb.append(str2[i])
        }
        
        return sb.toString()
    }
}
class Solution {
    fun solution(code: String): String {
        val sb = StringBuilder()
        var mode = false
        code.forEachIndexed{ index, c ->
            val isOdd = index % 2 == 1

            if(c == '1') mode = !mode
            else if(mode && isOdd){
                sb.append(c)
            }else if(!mode && !isOdd){
                sb.append(c)
            }
        }
        return if(sb.isEmpty()) "EMPTY" else sb.toString()
    }
}
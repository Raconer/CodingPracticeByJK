class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 1

        val row = n/w + if(n%w == 0) 0 else 1
        val findRow = num/w + if(num%w == 0) 0 else 1
        val tempCol = w*findRow - num
        println("tempCol = $tempCol")
        val findCol = (if(findRow%2 == 0) w-tempCol  else  tempCol + 1) 

        var temp = num
        println("현재 층수 : $findRow / $findCol")
        println("홀수 Col : ${num/w}")

        if(row == findRow) return 1

        for(i in findRow..row){
            val value = if(i%2 == 0){
                print("짝[${  w - findCol}] -> ")
                w - findCol
            }else {
                print("홀[${findCol - 1}]-> ")
                findCol - 1

            }
            println("$temp + ${(value*2) + 1}")
            temp += ( value*2 )+1

            if(temp <= n) answer += 1
        }

        println("답 : $answer")
        println("=========")
        return answer
    }
}
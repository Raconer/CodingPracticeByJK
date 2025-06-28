class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        fun solution(n: Int, w: Int, num: Int): Int {
            var answer: Int = 1

            val row = n/w + if(n%w == 0) 0 else 1 // 총 층 수
            val findRow = num/w + if(num%w == 0) 0 else 1 // 찾을는 번호 층수
            val tempCol = w*findRow - num // 박스 위치
            val findCol = (if(findRow%2 == 0) w-tempCol  else  tempCol + 1)  // 오른쪽 기준 박스 위치
            var a = num

            for(i in findRow..row){ // 박스 층수 -> 전체 층수
                val value = if(i%2 == 0){ // 짝수, 홀수 등차 수열
                    w - findCol
                }else {
                    findCol - 1
                }
                a += ( value*2 )+1

                if(a <= n) answer += 1 // 등차 수열이 전체 박스 갯수보다 작으면 +1
            }

            return answer
        }
    }
}
class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
  return timelogs.filterIndexed { index, logs ->
            
            val checkTime = addMinute(schedules[index])
            val size = logs.size
            var isCheck = true
            for(day in 0 until size){
                 val checkDay = (startday + day-1)%7 +1

                if( checkDay != 6 && checkDay != 7 && checkTime < logs[day]){
                    isCheck = false
                    break
                }
            }
            isCheck
        }.count()
    }
    
    private fun addMinute(time:Int) : Int{

        val plus = 10
        var h = time/100
        var m = time%100

        m += plus
        if(m >= 60){
            h += 1
            m -= 60
        }
        return (h*100) + m
    }
}
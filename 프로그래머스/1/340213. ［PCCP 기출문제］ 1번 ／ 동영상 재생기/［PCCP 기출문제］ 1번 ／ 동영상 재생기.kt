class Solution {
    
    private var videoLenTime = 0
    private var opStartTime = 0
    private var opEndTime = 0
    
     fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {

     
        videoLenTime = changeTime(video_len)
        opStartTime = changeTime(op_start)
        opEndTime = changeTime(op_end)

        var posTime = changeTime(pos, true)

        commands.forEach {
            when(it){
                "next" -> {posTime = this.plusTime(posTime, 10)}
                "prev" -> {posTime = this.plusTime(posTime, -10)}
            }
        }
        val minute = posTime / 100
        val second = posTime % 100
        return "${if(minute < 10) "0$minute" else minute}:${if(second < 10) "0$second" else second}"
    }

    private fun changeTime(timeStr:String, isPosTime: Boolean = false):Int{
        val timeList = timeStr.split(":")
        val time =  timeList[0].toInt()*100 + timeList[1].toInt()
          return if(isPosTime && time in opStartTime..opEndTime) opEndTime else time
    }

    private fun plusTime(time:Int, addTime:Int) :Int{
        var minute = time/100
        var second = time%100

        second += addTime

        if(60 <= second) {
            minute += 1
            second -= 60
        } else if(second < 0){
            minute -= 1
            second = 60 + second
            if((minute*100) + second < 10){
                minute = 0
                second = 0
            }
        }

        var time = (minute*100) + second

       if( videoLenTime  < time){
           time = videoLenTime
       }

       return if(time in opStartTime..opEndTime ){
           opEndTime
       } else time
    }

}
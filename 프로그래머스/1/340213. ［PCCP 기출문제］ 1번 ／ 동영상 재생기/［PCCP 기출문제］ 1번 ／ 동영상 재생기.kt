class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        val videoLenTime = changeSecond(video_len)
        var posTime = changeSecond(pos)
        val opStartTime = changeSecond(op_start)
        val opEndTime = changeSecond(op_end)
        
        if(posTime in opStartTime..opEndTime) posTime = opEndTime
        
        commands.forEach{
            posTime = when(it){
                "next" -> (posTime + 10).coerceAtMost(videoLenTime)
                "prev" -> (posTime - 10).coerceAtLeast(0)
                else -> posTime
            }
            
             if(posTime in opStartTime..opEndTime) posTime = opEndTime
        }
        
       
        return "%02d:%02d".format(posTime/60, posTime%60)
    }
    
    private fun changeSecond(timeStr:String):Int{
        val time = timeStr.split(":")
        val minute = time[0].toInt() * 60
        val second = time[1].toInt()
        return minute + second
    }
}
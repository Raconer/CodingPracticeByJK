
import java.util.LinkedList
import java.util.Queue


class Solution {
    fun solution(operations: Array<String>): IntArray {
        val queue:Queue<Int> = LinkedList<Int>()

        operations.forEach {
            this.cmdAction(it, queue)
        }

        return if(queue.isEmpty()) intArrayOf(0,0)
        else {
            val max = this.findMinMax(queue, true)
            val min = this.findMinMax(queue, false)
            intArrayOf(max, min)
        }
    }
    
      fun cmdAction(cmd:String, queue: Queue<Int>){

       if(cmd.startsWith("I ")){ // 값 넣기
           val number = cmd.split(" ")[1].toInt()
           queue.offer(number)
       }else if(cmd == "D 1"){ // 최대값 삭제
            queue.remove(this.findMinMax(queue, true))
       }else if(cmd == "D -1"){ // 최소값 삭제
           queue.remove(this.findMinMax(queue, false))
       }
    }

    fun findMinMax(queue: Queue<Int>, isMinMax: Boolean):Int{
        var number:Int? = null
        val tempQueue:Queue<Int> = LinkedList(queue)

        while(tempQueue.isNotEmpty()){
            val tempNumber = tempQueue.poll()

            number?.let {
                if(isMinMax && it < tempNumber){
                    number = tempNumber
                } else if(!isMinMax && it > tempNumber){
                    number = tempNumber
                }
            }?:run {
               number = tempNumber
            }


        }

        return number?:0
    }
}
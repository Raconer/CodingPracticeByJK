package com.kotlin.feature.dfs.makeN

import test.TestRunner
import test.vo.TestCaseList
import java.util.*

class Solution {

    fun solution(target:Int): Int {
        val visited = BooleanArray(target + 5)
        val queue:Queue<Pair<Int, Int>> = LinkedList()
        queue.add(0 to 0)
        visited[0] = true

        while(queue.isNotEmpty()) {
            val (value, count) = queue.poll()
            if(target == value ) {
                return count
            }

            for(i in 1..3) {
                val next =  value + i

                if(next <= target && !visited[next]) {
                    visited[next] = true
                    queue.add(next to count + 1)
                }
            }
        }


        return -1
    }



    fun testCase(): TestCaseList {
        val testCaseList = TestCaseList()
        testCaseList.add(
          2,
            this.solution(4))
        testCaseList.add(
            1,
            this.solution(1))

        testCaseList.add(
            2,
            this.solution(6))
        testCaseList.add(
            3,
            this.solution(7))


        return testCaseList
    }
}

fun main() {

    TestRunner.run(Solution::class)
}

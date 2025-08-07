package com.kotlin.feature.dp.makeN

import test.TestRunner
import test.vo.TestCaseList
import java.util.*

class Solution {
    fun solution(N: Int, number: Int): Int {
        if(N == number) return 1

        val dp = Array(N+1) { mutableSetOf<Int>() }

        for(i in 1 .. 8){
            dp[i].add("${N}".repeat(i).toInt())

            for(j in 1 until i){
                for(a in dp[j]){
                    for(b in dp[i - j]){
                        dp[i].add(a + b)
                        dp[i].add(a - b)
                        dp[i].add(a * b)
                        if(b != 0) dp[i].add(a / b)

                    }
                }

            }
            if (dp[i].contains(number)) return i

        }


        return -1
    }



    fun testCase(): TestCaseList {
        val testCaseList = TestCaseList()
        testCaseList.add(
          4,
            this.solution(5, 12))
//        testCaseList.add(
//            3,
//            this.solution(2, 11))

        return testCaseList
    }
}

fun main() {

    TestRunner.run(Solution::class)
}

package com.kotlin.feature.dp.triangle

import test.TestRunner
import test.vo.TestCaseList
import java.util.Arrays

class Solution {
    fun solution(triangle: Array<IntArray>): Int {
        val row = triangle.size
        val dp = Array(row){ triangle[it].clone() }

        for(i in row - 2 downTo 0){
            for(j in triangle[i].indices){
                dp[i][j] += maxOf(dp[i+1][j], dp[i+1][j+1])
            }
        }
        println(dp.contentDeepToString())
        return  dp[0][0]
    }



    fun testCase(): TestCaseList {
        val testCaseList = TestCaseList()
        testCaseList.add(
          30,
            this.solution(
                arrayOf(
                    intArrayOf(7),
                    intArrayOf(3, 8),
                    intArrayOf(8, 1, 0),
                    intArrayOf(2, 7, 4, 4),
                    intArrayOf(4, 5, 2, 6, 5),
                )
            ))  // target을 만드는 최소 동전 갯수

        testCaseList.add(
            30,
            this.solution(
                arrayOf(
                    intArrayOf(7),
                    intArrayOf(3, 8),
                    intArrayOf(8, 1, 300),
                    intArrayOf(2, 7, 4, 4),
                    intArrayOf(1, 1, 1, 6, 5),
                )
            ))



//        testCaseList.add(
//            3,
//            this.solution(2, 11))

        return testCaseList
    }
}

fun main() {

    TestRunner.run(Solution::class)
}

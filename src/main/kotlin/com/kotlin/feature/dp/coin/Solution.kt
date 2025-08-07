package com.kotlin.feature.dp.coin

import test.TestRunner
import test.vo.TestCaseList
import java.util.*

class Solution {
    fun solution(coins: IntArray, target: Int): Int {
        val dp = IntArray(target + 1){Int.MAX_VALUE}
        dp[0] = 0

        for(i in 1..target){
            for(coin in coins){
                if( i - coin >= 0 && dp[i - coin] != Int.MAX_VALUE ){
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }

        return if (dp[target] == Int.MAX_VALUE) -1 else dp[target]
    }



    fun testCase(): TestCaseList {
        val testCaseList = TestCaseList()
        testCaseList.add(
          2,
            this.solution(intArrayOf(1, 3, 4),6))  // target을 만드는 최소 동전 갯수
//        testCaseList.add(
//            3,
//            this.solution(2, 11))

        return testCaseList
    }
}

fun main() {

    TestRunner.run(Solution::class)
}

package com.kotlin.exam

import test.TestRunner.run
import test.vo.TestCaseList

class Solution {
    fun solution(s:String):String{
        return s
    }

    fun testCase(): TestCaseList {
        val testCaseList = TestCaseList()
        testCaseList.add("TestCase 01", this.solution("TestCase 03"))
        testCaseList.add("TestCase 02", this.solution("TestCase 02"))
        return testCaseList
    }
}

fun main() {
    run(Solution::class)
}
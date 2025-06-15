package exam;

import test.TestRunner;
import test.vo.TestCaseList;

public class Solution {
    public String solution(String s) {

        return s;
    }

    public TestCaseList testCase() {
        var testCaseList = new TestCaseList();
        testCaseList.add("TestCase 01", this.solution("TestCase 03"));
        testCaseList.add("TestCase 02", this.solution("TestCase 02"));
        return testCaseList;
    }

    public static void main(String[] args) {
        TestRunner.run(Solution.class);
    }
}

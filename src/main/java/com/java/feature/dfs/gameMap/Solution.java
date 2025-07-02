package com.java.feature.dfs.gameMap;

import test.TestRunner;
import test.vo.TestCaseList;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[][] maps) {
        int[] moveYList = new int[]{ 1, -1, 0,  0};
        int[] moveXList = new int[]{ 0,  0, 1, -1};
        int ySize = maps.length;
        int xSize = maps[0].length;

        int[][] distance = new int[ySize][xSize];
        distance[0][0] = 1;
        Queue<int[]> currentQueue = new LinkedList<>();
        currentQueue.add(new int[]{0, 0}); // 현재 (Y, X)

        while(!currentQueue.isEmpty()) {
            int[] current = currentQueue.poll();
            int currentY = current[0];
            int currentX = current[1];

            for(int i = 0; i < 4; i++ ){
                int moveY = currentY + moveYList[i];
                int moveX = currentX + moveXList[i];

                if( 0 <= moveY && moveY < ySize
                    && 0 <= moveX  && moveX < xSize
                    && maps[moveY][moveX] == 1 ){
                    distance[moveY][moveX] = distance[currentY][currentX] + 1;
                    maps[moveY][moveX] = 0;
                    currentQueue.add(new int[]{moveY, moveX});
                }
            }
        }

        int answer = distance[ySize - 1][xSize - 1];

        if(answer == 0 ) return -1;

        return answer;
    }

    public TestCaseList testCase() {
        var testCaseList = new TestCaseList();
       testCaseList.add(11, this.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }));
        testCaseList.add(-1, this.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}}));
          testCaseList.add(11, this.solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1}}));
        return testCaseList;
    }

    public static void main(String[] args) {
        TestRunner.run(Solution.class);
    }
}

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
       int goalY = maps.length;
        int goalX = maps[0].length;

        int[] moveX = new int[]{ 0, 0, 1, -1};
        int[] moveY = new int[]{-1, 1, 0,  0};

        Queue<int[]> queue = new LinkedList<>(); // 현재 위치 (Y, X)
        int[][] visited = new int[goalY][goalX];

        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()){
            int[] player = queue.poll();
            int playerY = player[0];
            int playerX = player[1];

            if(playerY == goalY && playerX == goalX){ return visited[goalY][goalX]; }

            for(int i = 0; i < 4; i++){
                int tempY = playerY + moveY[i];
                int tempX = playerX + moveX[i];

                if( 0 <=  tempY && tempY < goalY
                        && 0 <= tempX && tempX < goalX ){
                    if(maps[tempY][tempX] == 1 ){
                        visited[tempY][tempX] = visited[playerY][playerX] + 1;
                        maps[tempY][tempX] = 0;
                        queue.add(new int[]{tempY, tempX});
                    }
                }
            }
        }

        int answer = visited[goalY - 1][goalX - 1];
        if(answer == 0){
            answer = -1;
        }

        return answer;
    }
}
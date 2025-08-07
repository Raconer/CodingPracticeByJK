import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int size = arr.length;
        int n = size/2  + 1;
        
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];     
        
        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(arr[i*2]);
            maxDp[i][i] = value;
            minDp[i][i] = value;
        }
        
        for(int len = 2; len <= n; len++){
            for(int y = 0; y <= n - len; y++){
                int x = y + len - 1;
                maxDp[y][x] = Integer.MIN_VALUE;
                minDp[y][x] = Integer.MAX_VALUE;
        
                for(int tempX = y; tempX < x; tempX++){
                    String ops = arr[tempX * 2 + 1];
                    
                    int max = maxDp[y][tempX];
                    int min = minDp[y][tempX];
                    
                    int maxVal = maxDp[tempX + 1][x];
                    int minVal = minDp[tempX + 1][x];
                    
                    if(ops.equals("+")){
                        maxDp[y][x] = Math.max(maxDp[y][x], max + maxVal);
                        minDp[y][x] = Math.min(minDp[y][x], min + minVal);
                    }else if(ops.equals("-")){
                        maxDp[y][x] = Math.max(maxDp[y][x], max - minVal);
                        minDp[y][x] = Math.min(minDp[y][x], min - maxVal);
                    }
                    
                    
                }
            
            }
        }
        
      
        
        return maxDp[0][n-1];
    }
}